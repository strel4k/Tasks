package com.str.tsk2;

import java.util.*;

public class DupliesChecker {
    public static boolean containsDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {1, 1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Result: " + containsDuplicates(nums1));
        System.out.println("Result: " + containsDuplicates(nums2));
    }
}
