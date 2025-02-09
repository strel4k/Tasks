package com.str.tsk2;

import java.util.*;

public class FindIndxes {
    public static int[] findIndxes(int[] array, final int number) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = number - array[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(array[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = {3, 8, 15, 17};
        int number = 23;

        int[] result = findIndxes(array, number);
        System.out.println(Arrays.toString(result));

    }
}