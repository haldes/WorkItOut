package com.haldes.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {1, 6, 8, 3, 7, 3 , -20};
        System.out.println("Hello Selection sort " + Arrays.toString(nums));

        SelSrt sr = new SelSrt();
        int[] result = sr.doSelSort(nums);
        System.out.println("Result is : " + Arrays.toString(result));
    }


}

class SelSrt {

    public int[] doSelSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            int minVal = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {

                if(arr[j] < minVal){
                    minVal = arr[j];
                    minIndex = j;
                }

            }

            // Swap values
            int t = arr[i];
            arr[i] = minVal;
            arr[minIndex] = t;
            System.out.println("arr = [" + Arrays.toString(arr) + "]");

        }
        return arr;
    }

}
