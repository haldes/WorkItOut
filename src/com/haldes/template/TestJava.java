package com.haldes.template;

import java.util.Arrays;

public class TestJava {

    public static void main(String[] args) {

        //Integer[] nums = new Integer[]{-3, 2, -3, 4, 2};
        //Integer[] nums = new Integer[]{1,2};
        Integer[] nums = new Integer[]{-2,0,91,-43,-67,-10,-46,58,-32,-4,-23,-19,-47,93,2,30,-35,-28,-92,-71,-59,51,0,-23,64,-34,62,-78,85,-26,16,0,-97,-28,17,14,-85,-93,25,-86,71,60,72,53,82,22,-93,-56,-12,-55,-22,-22,-91,14,56,45,-23,61,5,-74,53,16,-20,47,77,86,4,62,-29,68,-57,-87,-87,38,-63,-86,-49,-23,81,-18,-100,17,-82,64,-2,89,44,10};
        int minStrval = 0;
        int len = nums.length;
        // create an prefix sum array
        int[] pfx = new int[len];
        pfx[0] = nums[0];
        for (int i = 1; i < len; i++) {
            pfx[i] = pfx[i - 1] + nums[i];
        }

        //for (int i = 1; i < 102; i++) {
        int i = 1;
        while(i > 0){
            boolean isValid = true;
            for (int j = 0; j < len; j++) {
                if (i + pfx[j] < 1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                minStrval = i;
                break;
            }
            i++;
        }

        System.out.println(minStrval);

    }
}

/*
 public static void main(String[] args) {

        int ans = 0 ;
        Integer[] nums = new Integer[]{10,4,-8,7};
        Integer [] prefix = new Integer [nums.length];
        prefix[0] = nums[0];
        for(int i =1 ; i < nums.length ; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        System.out.println(Arrays.toString(prefix));

        for( int i = 0; i < prefix.length -1 ; i ++) {
            if(prefix[i] >= (prefix[prefix.length - 1] - prefix[i])) {
                ans++;
            }
        }

        System.out.println(ans);

    }
 */