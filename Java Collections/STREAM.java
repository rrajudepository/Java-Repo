package DSAinJAVA.Lecture28;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;

public class STREAM {
    public static void main(String[] args) {
        System.out.println("\n\n");
        List<Integer> salaryList = new ArrayList<>();
        Collections.addAll(salaryList,3000, 4100, 9000, 1000, 3500, 4000);
        //salaryList.addAll(List.of(3000, 4100, 9000, 1000, 3500, 7000));
        //count() return long. so output can't be int
        long output = salaryList.stream().filter((Integer sal)-> sal>3000).count(); 
        System.out.println("Total Employee with salary > 3000: " +output);

        //From Collection:
        System.out.println("\n\n");

        List<Integer> salaryList2 = Arrays.asList(3000, 4100, 9000, 1000, 3500);
        Stream<Integer> st = salaryList2.stream();
       // st.sorted();
        List<Integer> list = st.sorted().collect(Collectors.toList()); //store in sortd form
        System.out.println(list);
        System.out.println("\n\n");

        List<List<String>> sentenceList=Arrays.asList(
            Arrays.asList("My", "Name", "IS","Rajksihor"),
            Arrays.asList("I", "AM","DOING","CODING"),
            Arrays.asList("It", "is","really","Awesome"));

           // Stream<String> wordStream = sentenceList.stream().flatMap((List<String> sentence)->sentence.stream());
            //List<String> word = wordStream.collect(Collectors.toList());
            //List<String> word = sentenceList.stream().collect(Collectors.toList());
        
            List<Integer> num = Arrays.asList(2,1,4,7,10,11,12);
            Stream<Integer> numStream = num.stream().filter((Integer val)-> val>=3)
                      .peek((Integer val)->System.out.println("After filter: "+val))
                      .map((Integer val)->(val*-1))
                      .peek((Integer val)->System.out.println("After negating :"+val))
                      .sorted()
                      .peek((Integer val)->System.out.println("After Sorted: "+val));

                      List<Integer> filterNumbersStream = numStream.collect(Collectors.toList());
            

                      
            List<Integer> num2 = Arrays.asList(2,1,3,4,7,10,11,12);
            //Sequential Processing
            long sequentialProcessingStartTime = System.currentTimeMillis();
            num2.stream()
                 .map((Integer val)-> val*val)
                 .forEach((Integer val)->System.out.println(val));
            System.out.println("Sequential Processing time taken: "+ (System.currentTimeMillis()-sequentialProcessingStartTime)+" milliseconds");
            
            //parallel Processing

            long parallelProcessingStartTime = System.currentTimeMillis();
            num2.parallelStream()
                .map((Integer val)->val*val)
                .forEach((Integer val)->System.out.println(val+" "));
            System.out.println("Parallel processing time taken: "+ (System.currentTimeMillis()-parallelProcessingStartTime)+" milliseconds");

        


        

    }
}
