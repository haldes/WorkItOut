package com.haldes.recursion;

/*

Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).


factorial(1) → 1
factorial(2) → 2
factorial(3) → 6

*/

public class Factorial {

    public static void main(String[] args){

    	// 5! =  5 * 4 * 3 * 2 * 1
    	int nums = 5;
        System.out.println("Hello !!!");
        FactorialRecursive f = new FactorialRecursive();
        int result = f.fact(nums);

        System.out.println("Result is : "+ result);

    }

}

class FactorialRecursive{

	public int fact(int nums){

		// 5! =  5 * 4 * 3 * 2 * 1
		// 5! =  5 * (4 * (3 * (2 * 1)))
		int result = 1;

		if (nums == 0){ // Base case
			return 1;
		} else {
			result = nums * fact(nums - 1 );
		}

		return result;	
	}
	
}
