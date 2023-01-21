package org.example.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PortUtils {

    public static String stringSequence(int lowerBound, int upperBound) {
        StringBuilder numberSequence = new StringBuilder();
        for (int i = lowerBound; i <= upperBound; i++) {
            numberSequence.append(i);
            numberSequence.append(",");
        }
        return numberSequence.toString();
    }

    public static String[] unfoldStringArray(String[] indexes) {
        for (int i = 0; i < indexes.length; i++) {
            StringBuilder sequenceNumbers = new StringBuilder();
            String[] splitArray = indexes[i].split(",");
            for (String s : splitArray) {
                String part = s;
                if (part.contains("-")) {
                    String[] subParts = part.split("-");
                    part = stringSequence(Integer.parseInt(subParts[0]), Integer.parseInt(subParts[1]));
                    sequenceNumbers.append(part);
                } else {
                    sequenceNumbers.append(part);
                    sequenceNumbers.append(",");
                }
            }
            // remove last character
            sequenceNumbers = new StringBuilder(sequenceNumbers.substring(0, sequenceNumbers.length() - 1));

            indexes[i] = sequenceNumbers.toString();
        }
        return indexes;
    }

    public static List<List<Integer>> cartesianProduct(List<List<Integer>> lists) {
        return lists.stream()
                .map(list -> list.stream().map(Collections::singletonList)
                        .collect(Collectors.toList()))
                .reduce((lst1, lst2) -> lst1.stream()
                        .flatMap(inner1 -> lst2.stream()
                                .map(inner2 -> Stream.of(inner1, inner2)
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList())))
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public static int[] convertStringArrayToIntArray(String[] stringArray) {

        return Arrays.stream(stringArray)
                .map(s -> s.split(","))
                .flatMapToInt(strings -> Arrays.stream(strings)
                        .mapToInt(Integer::parseInt))
                .sorted()
                .toArray();
    }
}
