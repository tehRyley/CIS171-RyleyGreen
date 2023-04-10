package com.mycompany.radixsort;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ryley Ireland Green
 */
public class RadixSort {

    //Main and testing
    public static void main(String[] args) {
        int[] list = randomGen(1000000);
        //Comment out this for-loop to see the array before radix sort
        for (int i = 0; i < 7; i++) {
            radix = i;
            bucketSort(list);
        }
        //Display array in a readable list
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
            System.out.println("\n");
        }
    }

    //Radix sort
    public static void bucketSort(int[] list) {
        ArrayList<Integer>[] bucket = new ArrayList[10];
        for (int i = 0; i < list.length; i++) {
            int key = getKey(list[i]);
            if (bucket[key] == null) {
                bucket[key] = new ArrayList<>();
            }
            bucket[key].add(list[i]);
        }

        int k = 0;
        for (ArrayList<Integer> bucket1 : bucket) {
            if (bucket1 != null) {
                for (int j = 0; j < bucket1.size(); j++) {
                    list[k++] = (int) bucket1.get(j);
                }
            }
        }
    }

    //Generate 1,000,000 random integers (0 - 1,000,000 in value)
    public static int[] randomGen(int length) {
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            Random rand = new Random();
            nums[i] = rand.nextInt(1000000 + 1);
        }
        return nums;
    }

    //Generate keys
    static int radix = 1;

    public static int getKey(int key) {
        for (int i = 0; i < radix; i++) {
            key = key / 10;
        }
        return key % 10;
    }
}
