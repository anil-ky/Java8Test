package com.java8.features.streams.test;

import com.java8.features.model.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Streams:
//  1. Configuration (filter and map) - map
//  2. Processing (collect, count, sorted, min/max, forEach, toArray and of()) - reduce
public class Java8Streams {
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
        List<Float> streamWay = productList.stream().filter(product -> product.getPrice() <= 5000)
                .map(price -> price.getPrice())
                .collect(Collectors.toList());
        System.out.println("Filter List into new List:: " + streamWay);
        streamWay.stream().forEach(price -> System.out.print(price + " | "));

        System.out.println("\nSorted: ");
        streamWay.stream().sorted().forEach(x -> System.out.print(x + " | "));

    }
}