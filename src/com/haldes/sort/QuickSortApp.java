package com.haldes.sort;

import java.util.Arrays;

public class QuickSortApp {

    public static void main(String[] args) {

        System.out.println("Hello Quick Sort !!!");

        int[] nums = {8,7,6,5,4,3,2,1};

        QuickSort qs = new QuickSort();

        int[] result = qs.QSort(nums);
        System.out.println("Result is " + Arrays.toString(nums));
    }


}

class QuickSort {

    public int[] QSort(int[] nums) {

        System.out.println("======================= Start =============");
        System.out.println("Hello Qsort !!!" + Arrays.toString(nums));

        if(nums.length < 2){
            return nums;
        }

        // find pivot as the last element
        int pivot = nums[nums.length / 2];
        System.out.println("Pivot value : "+pivot);

        // Get the left and right sub-arrays counts
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < pivot) {
                leftCount++;
            } else if (nums[i] == pivot){
                continue;
            }
            else {
                rightCount++;
            }

        }
        System.out.println("left count : "+leftCount+" right count : "+rightCount);
        // Create left and right sub-arrays

        int[] leftArr = new int[leftCount];
        int[] rightArr = new int[rightCount];

        int l = 0;
        int r = 0;

        for (int i=0; i<nums.length; i++ ){
            if(nums[i] < pivot){
                leftArr[l++] = nums[i];
            } else if (nums[i] == pivot) {
                continue;
            }
            else {
                rightArr[r++] = nums[i];
            }
        }

        System.out.println("left Arr : "+ Arrays.toString(leftArr));
        System.out.println("right Arr : "+ Arrays.toString(rightArr));

        leftArr = QSort(leftArr);
        rightArr = QSort(rightArr);

        System.arraycopy(leftArr,0,nums,0,leftArr.length);
        nums[leftArr.length] = pivot;
        System.arraycopy(rightArr,0,nums,leftArr.length + 1,rightArr.length);

        System.out.println(" Sorted thus far : " + Arrays.toString(nums));
        System.out.println("======================= End ============= \n\n");

        return nums;
    }


}
