package DSAinJAVA.LinkedList;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ll {
    node head;
    node tail;
    public ll(){
        this.head = null;
        this.tail = null;
    }

    //Insert at the beggining
    public void insertAtBeggining(int data){
        node newNode = new node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }

    }

    //Insert at the end
    public void insertAtEnd(int data){
        node newNode = new node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteAtBegginging(){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        node current = head;
        head = head.next;
        current.next = null;
        if(head == null){
            tail = null;
        }

  
    }

    public void deleteAtEnd(){
        if(head == null){
            System.out.println("\nLinked List is empty");
            return;
        }
        if(head.next == null){
            head=tail=null;
            return;
        }
        node current = head;
        while(current.next != tail){
            current = current.next;
        }
        current.next = null;
        tail = current;
        return;
    }

    public void printLinkedList(){
        node current = head;
        if(head==null){
            System.out.println("\nLinked List is empty");
            return;
        }
        while(current != null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println("null\n\n");
        return;

    }
   
    public void insertValues(int val, int position){
        node newNode = new node(val);
        node current = head;
        while(current != null && position>2){
            current = current.next;
            position--;
        }
        node temp= current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    public void search(int val){
        node current = head;
        while(current != null){
            if(current.data == val){
                System.out.println("\nNode with value "+val+" is found in linked list");
                return;
            }
            current=current.next;
        }
        System.out.println("\nNode with value "+val+" is not found in linked list");
        return;
    }

    public void reverseLinkedList(){
        node prev = null;
        node current = head;
        node next = null;
        node tail2 = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        tail = tail2;
        
    }

    public static void main(String[] args){
        System.out.println("\n\nWelcome to Linked List implementation in Java\n\n");

        List<Integer> values = new ArrayList<>();
        Collections.addAll(values, 1,3,4,2,7,6,8,5,10,11,13,12);
        ll list = new ll();
        for(int val : values){
            list.insertAtBeggining(val);
        }
        System.out.println("Linked List after inserting values at beggining: ");
        list.printLinkedList();
        list.reverseLinkedList();
        System.out.println("\nLinked List after reversing: ");
        list.printLinkedList();

        list.insertAtBeggining(0);
        list.insertAtEnd(9);
        System.out.println("\nLinked List after inserting 0 at beggining and 9 at end: ");
        list.printLinkedList();

        list.deleteAtBegginging();
        list.deleteAtEnd();
        System.out.println("\nLinked list after deleting node at beggining and end: ");
        list.printLinkedList();
        
        list.insertValues(15, 5);
        System.out.println("\nLinked list after inserting 15 at position 5: ");
        list.printLinkedList();
 
        System.out.println("\nSearching nodes 10 and 20 in linked list: ");
        list.search(10);
        list.search(20);

        list.insertValues(14, 10);
        System.out.println("\nLinked list after inserting 14 at position 10: ");
        list.printLinkedList();

    }
}
