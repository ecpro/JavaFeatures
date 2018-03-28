package com.piyush.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by eccspro on 25/03/18.
 */
public class StreamsAndLambda {

    public static void main(String args[]) {
        List<String> list = Arrays.asList("java", "jdk", "ws","soap");
        //list.parallelStream().forEach(listItem -> System.out.println(listItem));
        //System.out.println();
        //list.parallelStream().filter(listItem -> listItem.startsWith("j")).forEach(filtered -> System.out.println(filtered));

        List<Integer> listOfInt = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = listOfInt.parallelStream().map(listItem -> listItem * listItem).collect(Collectors.toList());
        collect.stream().forEach(item -> System.out.println(item));

        IntSummaryStatistics intSummaryStatistics = listOfInt.stream().mapToInt(x -> x).summaryStatistics();

    }
}
