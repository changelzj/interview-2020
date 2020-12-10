package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class SumTwo {

    /**
     * 暴力破解
     */
    public static int[] sum(int [] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (target - arr[i] == arr[j]) {
                    return new int[] {i ,j};
                }
            }
        }
        return null;
    }




    /**
     * 哈希解法
     */
    public static int[] hash(int [] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int partner = target - arr[i];
            if (map.containsKey(partner)) {
                return new int[] {map.get(partner), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }




    public static void main(String[] args) {
        int arr[] = new int[] {3, 4, 7, 5};
        int target = 10;
        int[] sum = sum(arr, target);
        System.out.println(Arrays.toString(sum));

        sum = hash(arr, target);
        System.out.println(Arrays.toString(sum));
    }
}




