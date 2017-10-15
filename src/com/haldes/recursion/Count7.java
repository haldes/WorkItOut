package com.haldes.recursion;


/*
http://codingbat.com/prob/p101409
Given a non-negative int n, return the count of the occurrences of 7 as a digit, 
so for example 717 yields 2. (no loops). 
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).


count7(717) → 2
count7(7) → 1
count7(123) → 0
*/
public class Count7 {

	public static void main(String[] args){

		System.out.println("Hello Count 7 !!!");
		int nums = 77780007;
		Count7Solution cs = new Count7Solution();
		int result = cs.SolRecursive(nums);

		System.out.println("Result is : " + result);


	}
}

class Count7Solution {

	public int SolRecursive(int nums){
		

		// 126 = checkIfLastDigitIs7(126) + checkIfLastDigitIs7(12) + checkIfLastDigitIs7(1) + less then zero then 0 (base case)
		int result = 0;

		if (nums <= 1) { // base case
			return 0;
		}


		result = checkIfLastDigitIs7(nums) + SolRecursive(nums/10);

		return result;
	}

	public int checkIfLastDigitIs7(int nums){

		if(nums % 10 == 7){
			return 1;
		} else {
			return 0;
		}
	}

}