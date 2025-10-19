package DSAinJAVA;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}*/
public class BinaryTree {
    static int idx = -1;
    static Node buildTree(List<Integer> preorder){
        idx++;
        if(idx>=preorder.size() || preorder.get(idx)==-1){
            return null;
        }
        Node newNode = new Node(preorder.get(idx));
        if(idx ==0){
            System.out.println("Root node is created with data: "+newNode.data);
        }
            newNode.left = buildTree(preorder);
            newNode.right =buildTree(preorder);
           // System.out.println("Node is created with data: "+newNode.data);
            return newNode;
    }

    static void preorderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static void inorderTraversal(Node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
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
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            System.out.print(currNode.data+" ");
            if(currNode.left != null){
                queue.add(currNode.left);
            }
            if(currNode.right != null){
                queue.add(currNode.right);
            }

        }
        return;

    }

    static void levelwiseLevelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            if(currNode == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                    continue;
                }
            }

            System.out.print(currNode.data+" ");
            if(currNode.left !=null){
                queue.add(currNode.left);
            }
            if(currNode.right !=null){
                queue.add(currNode.right);
            }
        }
    }

    static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    static int leftheight(Node root){
        if(root == null){
            return 0;
        }
        return 1 + heightOfTree(root.left);
    }

    static int rightheight(Node node){
        if(node == null){
            return 0;
        }
        return 1 + heightOfTree(node.right);
    }

    static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return 1 + countOfNodes(root.left) + countOfNodes(root.right);
    }

    static void kthLevelTraversal(Node root, int k){
        if(root == null){
            return;
        }
        if(k==1){
            System.out.print(root.data+" ");
        }
        kthLevelTraversal(root.left, k-1);
        kthLevelTraversal(root.right, k-1);
    }

    static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftOfHeight = leftheight(root);
        int rightOfHeight = rightheight(root);
        int diaThroughRoot = leftOfHeight + rightOfHeight -1;
        int leftDia = diameterOfTree(root.left);
        int rightDia = diameterOfTree(root.right);
        return Math.max(diaThroughRoot, Math.max(leftDia, rightDia));

    }
    public static void main(String[] args){

        System.out.println("\n\nWelcome to Binary Tree Data Structure\n\n");
        List <Integer> inorder = new ArrayList<>(Arrays.asList(1,2,4,-1,-1,5,-1,-1,3,7,-1, 8,-1,-1,6,9,-1,-1,10, 11, -1, 12, -1));
        Node root = buildTree(inorder);
        System.out.println("root data is: "+root.data);
        System.out.println("left child of root is: "+root.left.data);
        System.out.println("right child of root is: "+root.right.data);

        System.out.print("\nPreorder Traversal: ");
        preorderTraversal(root);
        System.out.println();

        System.out.print("\nInorder Traversal: ");
        inorderTraversal(root);
        System.out.println();

        System.out.print("\nPostorder Traversal: ");
        postorderTraversal(root);

        System.out.println("\nlevel order tarversal is: ");
        levelOrderTraversal(root);

        System.out.println("\nLevel wise level order traversal is: ");
        levelwiseLevelOrderTraversal(root);
        
        System.out.println("\nHeight of tree is :"+heightOfTree(root));
        heightOfTree(root);
        
        System.out.println("\nLeft height of tree is :"+leftheight(root));
        leftheight(root);

        System.out.println("\nRight height of tree us: "+rightheight(root));
        rightheight(root);

        System.out.println("\nSum of all nodes in the tree is: "+sumOfNodes(root));
        sumOfNodes(root);

        System.out.println("\nCount of all nodes in the tree is: "+countOfNodes(root));
        countOfNodes(root);

        int k = 3;
        System.out.println("\nNodes at level " +k+ " are: ");
        kthLevelTraversal(root, k);

        System.out.println("\nDiameter of the tree is: "+diameterOfTree(root));

    }
}
