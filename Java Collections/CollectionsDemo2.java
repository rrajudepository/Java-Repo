package DSAinJAVA.Lectores22_23_24;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;
public class CollectionsDemo2 {
    public static void main(String[] args){
        /* 
        Integer[] array = {4,5,6,7,2,3,8,9,5,1,3};
        Arrays.sort(array);
        System.out.print("\n\nIncreasing order of array: ");
        for(Integer i : array){
            System.out.print(i+" ");
        }
        System.out.println();
        Arrays.sort(array, (Integer a, Integer b)-> b - a); // Decreasing order
        System.out.print("Decreasing order of array: ");
        for(Integer i : array){
            System.out.print(i+" ");
        }
        System.out.println();

        Arrays.sort(array, (Integer a, Integer b)-> a - b); // Increasing order
        System.out.print("Increasing order of array: ");
        */

        /*for(Integer i : array){
            System.out.print(i+" ");
        }
        System.out.println();*/

        /* 
        Arrays.stream(array).forEach(val -> System.out.print(val+" "));
        System.out.println();
        System.out.println("\nUsing List forEach:");//Array do not have foreach method like list and others
        Arrays.asList(array).forEach(val -> System.out.print(val + " "));
        System.out.println();
        
        Car[] carArray=new Car[3];
        carArray[0] = new Car("SUV", "Electric");
        carArray[1] = new Car("Creta", "Petrol");
        carArray[2] = new Car("Tata","Diesal");
        //Decreasing order(Lexographically) for carType
        Arrays.sort(carArray, (Car obj1, Car obj2)-> obj2.carType.compareTo(obj1.carType));
        for(Car car : carArray){
            System.out.println(car.carName + " "+car.carType);
        }

        System.out.println("\n\n");
        
        //Increasing order(Lexographically) for carType
        Arrays.sort(carArray, (Car obj1, Car obj2)-> obj1.carType.compareTo(obj2.carType));
        for(Car car : carArray){
            System.out.println(car.carName + " "+car.carType);
        }

        System.out.println("\n\n");


        //Decreasing order(Lexographically) for carName
        Arrays.sort(carArray, (Car obj1, Car obj2)-> obj2.carName.compareTo(obj1.carName));
        for(Car car : carArray){
            System.out.println(car.carName + " "+car.carType);
        }
        System.out.println("\n\n");


        //Dequeue statnds for DOUBLE ENDED QUEUE

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addFirst(4);
        dq.addLast(5);
        dq.addLast(6);
        System.out.println("Last element in dequeue: "+dq.getLast());
        System.out.println("First element in dequeue: "+dq.getFirst());
        dq.removeFirst();
        dq.removeLast();

        System.out.println("Last element in dequeue: "+dq.getLast());
        System.out.println("First element in dequeue: "+dq.getFirst());

        */



        /* 
        List<Integer> list1 = new ArrayList<>();
        list1.add(0,300);
        list1.add(1, 100);
        list1.add(2, 200);
        System.out.println(list1);
        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n");

        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 600, 500, 400);
        list1.addAll(list2);
        System.out.println(list1);
        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n");


        List<Integer> list3 = new ArrayList<>();
        Collections.addAll(list3, 700,800,900);
        list1.addAll(2, list3);
        System.out.println(list1);
        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n");
        list1.replaceAll((Integer val)->-1*val);
        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");

        list1.set(5, 500);

        list1.sort((Integer a, Integer b)-> a-b); //Sorting in increasing order
        list1.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n");

        list1.sort((Integer a, Integer b)-> b-a); //sorting in decreasing order
        list1.forEach((Integer val)->System.out.print(val+" ")); 
        System.out.println("\n");

        list1.set(2, 300);
        list1.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n");

        list1.remove(6); //remove index 6 element
        list1.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n");
        
        System.out.println("Index of -800 is: "+list1.indexOf(-800)); //if no index available return -1

        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");

        //provide the index in listIterator, from where it has to start
        //traversing from backward
        System.out.println("Traversing from backward direction\n");
        ListIterator<Integer> it = list1.listIterator(list1.size());
        while(it.hasPrevious()){
            int preVal = it.previous();
            System.out.print(preVal+" ");
            if(preVal == -800){
                it.set(-50);
            }
        }
        System.out.println("\n\n");
        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");

        ListIterator<Integer> it2 = list1.listIterator();
        System.out.println("Traversing in forward direction \n");
        while(it2.hasNext()){
            int val = it2.next();
            System.out.print(val+" ");
            if(val==-400){
                it2.add(-100); //add -100 next to -400
            }
        }
        System.out.println("\n\n");
        list1.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");

        System.out.println("Sublist created with the help of list1: \n");
        List<Integer> sublist = list1.subList(1, 4);
        sublist.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");
        sublist.add(1000);
        sublist.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");




        

        //LinkedList implementation
        System.out.println("LinkedList Implementation");

        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(200);
        ll.addLast(300);
        ll.addLast(400);
        ll.addFirst(100);
        ll.addFirst(50);
        System.out.println("LinkedList is given by: ");
        ll.forEach((Integer val)->System.out.print(val+"->"));
        System.out.println("null\n\n");
        

        ll.add(0,500);
        ll.add(3,600);
        ll.forEach((Integer val)->System.out.print(val+"->"));
        System.out.println("null\n\n");

        System.out.println("4th element of linked list is: "+ll.get(3));


        //vector implementation same as arraylist, element can be access via index
        //less efficient than arraylist because lock/unlock internally
        System.out.println("\n\nVector implementation: ");
        Vector<Integer> num = new Vector<>();
        Collections.addAll(num,1,3,4,8,9,7,6,10,5);
        num.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n\n");
        
        num.add(3,-2);
        num.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n\n");

        num.replaceAll((Integer val)->2*val);
        num.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n\n");

        num.remove(5);
        num.forEach((Integer val)->System.out.print(val+" "));
        System.out.println("\n\n");

         */


        //Stack implementation
        System.out.println("Stack implementation is here");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        Collections.addAll(stack, 50,70,60);

        stack.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");
        
        

        stack.pop();
        stack.forEach((Integer val)-> System.out.print(val+" "));
        System.out.println("\n\n");

        while(stack.size()>0){
           int val = stack.pop();
           System.out.print(val+" ");
        }
        System.out.println("\n\n");












         




    }
}
