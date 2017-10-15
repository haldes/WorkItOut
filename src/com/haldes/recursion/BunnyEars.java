package com.haldes.recursion;

/*
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. 
The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. 
Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).


bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
*/

public class BunnyEars {

	public static void main(String[] args){
		System.out.println("Hello BunnyEars !!!");

		int nums = 5;
		BunnyEarsSolution be = new BunnyEarsSolution();
		int result = be.SolRecursive(nums);

		System.out.println("The result is : "+ result);

	}



}

class BunnyEarsSolution {

	public int SolRecursive(int nums){

		// 3 = GetNoOfEars(3) + GetNoOfEars(2) + GetNoOfEars(1)
		int result = 0;

		if(nums == 0 ){ // base Case
			return 0;
		}

		// Think recursion like this
		// Calculate for the first element + recursively call for the others
		//result = GetNoOfEars(nums) + SolRecursive(nums-1);

		if (nums % 2 == 0) {
			result =  3;
		} else {
			result =  2;
		}

		result = result + SolRecursive(nums - 1);

		return result;
	}

	public int GetNoOfEars(int i){

		if (i % 2 == 0) {
			return 3;
		} else {
			return 2;
		}
	}

}