package com.piyush.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eccspro on 22/03/18.
 */
public class CollectionExamples {

    public static void main(String args[]) {
        String x = "Hi";
        String y = "Bye";
        Set<String> set = new HashSet<>();
        set.add(x);
        set.add(y);

        System.out.println(set);
        set.forEach(s -> { System.out.println("y");});
        set.removeIf(s-> s.equals(y));
        System.out.println(set);
    }
}
