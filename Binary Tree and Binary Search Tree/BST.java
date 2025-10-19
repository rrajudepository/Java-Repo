package DSAinJAVA;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class BST {

    static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val <root.data){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;


    }

    static Node buildBST(List<Integer> values){
        Node root = null;
        for(int val : values){
            root = insert(root, val);
        }
        return root;
    }
     
    static void inorderTraversal(Node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }

    static void preorderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static void postorderTraversal(Node root){
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    static void levelOrderTraversal(Node root){
        if(root == null){
            System.out.println("BST is empt");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            System.out.print(currNode.data+" ");
            if(currNode.left != null){
                q.add(currNode.left);
            }
            if(currNode.right != null){
                q.add(currNode.right);
            }
        }

    }

    static void levelwiseLevelOrderTraversal(Node root){
        if(root == null){
            System.out.println("BST is empty");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            if(currNode == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                    continue;
                }else{
                    break;
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }

        }
    }

    static Node inorderSuccessorNode(Node root){
        Node curr = root;
        while(curr != null && curr.left != null){
            curr=curr.left;
        }
        return curr;
    }

    static Node deleteNode(Node root, int val){
        if(root == null){
            System.out.println("\nBST is empty or Node with value "+val+" not found");
            return null;
        }
        if(val < root.data){
            root.left = deleteNode(root.left, val);
        }else if(val > root.data){
            root.right = deleteNode(root.right, val);
        }else{
            // Node found
            //case 1: no child
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                //case 2: one child exists (right child)
                return root.right;
            }else if(root.right == null){
                //case 3 : one child exists (left child)
                return root.left;
            }else{
                //case 4 : both chils exist
                Node temp = inorderSuccessorNode(root);
                root.data = temp.data;
                root.left = deleteNode(root.left, temp.data); 
            }
        }
        return root;
    }

    static boolean searchNode(Node root, int val){
        if(root == null){
            System.out.println("BST is empty or Node with value "+val+" not found");
        }else if(root.data == val){
            return true;
        }else if(val < root.data){
            return searchNode(root.left, val);
        }else{
            return searchNode(root.right, val);
        }
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        Collections.addAll(values, 3,4,8,9,10,5,2,1,7,6,11);
        values.add(2,0);
        values.addAll(List.of(-2,-1,-3));
        System.out.println("\n\nWelcoe to Binary Search Tree Data Structure\n\n");
        System.out.println("Values to be inserted in BST are: "+values);

    
        Node root = buildBST(values);
        System.out.println("\nInorder Traversal of BST is: ");
        inorderTraversal(root);
        System.out.println("\nPreorder Traversal of BST is: ");
        preorderTraversal(root);
        System.out.println("\nPostorder Traversal of BST is: ");
        postorderTraversal(root);
        System.out.println("\nLevel Order Traversal of BST is: ");
        levelOrderTraversal(root);
        System.out.println("\nlevelwise level order traversal of BST is: ");
        levelwiseLevelOrderTraversal(root);

        deleteNode(root, 5);
        System.out.println("\nlevelwise level order traversal of BST after deleting node 5 is: ");
        levelwiseLevelOrderTraversal(root);
        deleteNode(root, 0 );
        System.out.println("\nlevelwise level order traversal of BST after deleting node 0 is: ");
        levelwiseLevelOrderTraversal(root);

        System.out.println("\n inorder traversal of BST after deletions is: ");
        inorderTraversal(root);

        deleteNode(root, 15);

        System.out.println("\n inorder traversal of BST after deletions is: ");
        inorderTraversal(root);

        System.out.println("\n\nEnter the node value to be searched in BST: ");
        int search = sc.nextInt();
        if(searchNode(root, search)){
            System.out.println("\nNode "+ search +" is found in BST");
        }else{
            System.out.println("\nNode "+ search + " is not fount in BST");
        }

    sc.close();

    }
}
