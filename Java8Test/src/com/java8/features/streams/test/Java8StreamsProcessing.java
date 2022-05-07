package com.java8.features.streams.test;

import com.java8.features.model.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Streams:
//  1. Configuration (filter and map) - map
//  2. Processing (collect, count, sorted, min/max, forEach, toArray and of()) - reduce
public class Java8StreamsProcessing {
    public static void main(String str[]) {

        // Before Java 8
        List<Float> pf = new ArrayList<Float>();
        List<Products> productList = new ArrayList<Products>();
        productList.add(new Products(1, "iPhone11", "64 GB 24MP", 5000f));
        productList.add(new Products(1, "iPhone12", "64 GB 24MP", 3000f));
        productList.add(new Products(1, "iPhone13", "64 GB 24MP", 2000f));
        productList.add(new Products(1, "iPhone15", "64 GB 24MP", 9000f));

        for (Products p : productList) {
            if (p.getPrice() <= 5000) {
                pf.add(p.getPrice());
            }
        }
        System.out.println(pf);

        // After Java 8

        // Collect
        List<Float> streamWay = productList.stream().filter(product -> product.getPrice() <= 5000)
                .map(price -> price.getPrice())
                .collect(Collectors.toList());
        System.out.println("Filter List into new List:: " + streamWay);
        streamWay.stream().forEach(price -> System.out.print(price + " | "));

        // Sorted
        System.out.println("\nSorted: ");
        streamWay.stream().sorted().forEach(x -> System.out.print(x + " | "));

        System.out.println("Filter my List into new List:: " + streamWay);
        streamWay.stream().forEach(x -> System.out.println(x));

        // Count
        System.out.println("Count");
        System.out.println(streamWay.stream().count());

        // Sorted
        System.out.println("\nSorted: ");
        streamWay.stream().sorted().forEach(x -> System.out.print(x + " | "));

        System.out.println("Filter my List into new List:: " + streamWay);
        streamWay.stream().forEach(x -> System.out.println(x));
        System.out.println("ASC" + streamWay.stream().sorted((a, b) -> a.compareTo(b)));

        // min/max
        System.out.println("Min/Max");
        System.out.println(streamWay.stream().min((i, j) -> i.compareTo(j)));
        System.out.println(streamWay.stream().max((i, j) -> i.compareTo(j)));

        // forEach
        streamWay.stream().forEach(x -> System.out.println("forEach::" + x));

        // toArray
        Object[] o = streamWay.toArray();
        for (Object c : o) {
            System.out.println(c);
        }

        // of() ANY GROUP OF VALUE
        Stream.of(1, 11, 222, 22333, 32323).forEach(z -> System.out.println(z));
        String[] name = {"LA01", "LA02", "LA03", "LA"};
        Stream.of(name).filter(x -> x.length() == 2).forEach(x -> System.out.println(x + "" + Thread.currentThread().getName()));
        List<Integer> listOfNumbers = Arrays.asList(222, 232, 43, 543);
        listOfNumbers.stream().forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));
    }
}