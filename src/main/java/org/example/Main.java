package org.example;

import org.example.utils.PortUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> expected= new ArrayList<>(){{
            add(Arrays.asList(7,8,9,10,11,12));
            add(List.of(8));
            add(Arrays.asList(10,11,12));
            add(List.of(6));
        }};
        System.out.println(PortUtils.cartesianProduct(expected));
    }
}
