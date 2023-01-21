package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.utils.PortUtils.*;

public class Port {
    private final String[] indexes;

    public Port(String[] indexes) {
        this.indexes = indexes;
    }

    // First method
    public int[] arrayToSequenceNumbers() {
        unfoldStringArray(this.indexes);
        return convertStringArrayToIntArray(indexes);
    }

    // second method
    public List<List<Integer>> arrayToShuffledSequenceArray() {

        unfoldStringArray(this.indexes);
        List<List<Integer>> list = Arrays.stream(this.indexes)
                .map(s -> Arrays.stream(s.split(",")).map(Integer::valueOf).collect(Collectors.toList()))
                .collect(Collectors.toList());
        list = cartesianProduct(list);


        return list;


    }

}
