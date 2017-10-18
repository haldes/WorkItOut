package com.haldes.recursion;

import java.util.Arrays;

/**
 * Given a string and a non-empty substring sub,
 * compute recursively the number of times that sub appears in the string,
 * without the sub strings overlapping.
 * <p>
 * strCount("catcowcat", "cat") → 2
 * strCount("catcowcat", "cow") → 1
 * strCount("catcowcat", "dog") → 0
 */
class SubString {

    public static void main(String[] args) {

        System.out.println("Hello Substring !!!");
        SubStringSol ss = new SubStringSol();
        String str = "iiiijj";
        //char[] str = {'c','a','t'};
        String subStr = "ii";

        int result = ss.IsMatch(str.toCharArray(), subStr.toCharArray(), 0);
        System.out.println("Result is : " + result);
    }
}

class SubStringSol {

	/*public int substr(char[] str, char[] subStr){
        int result = 0;
		int ptr = 0;



		result = IsMatch(str, subStr, ptr);

		return result;
	}*/

    public int IsMatch(char[] str, char[] subStr, int ptr) {

        // substr('catcowcat') = substr('[cow]catcow') 0-2 + substr('cow[cat]cow') 3-5 + substr('cowcat[cow]' 6-8)
        // result +=

        int result = 0;

        if (ptr >= str.length) {
            return 0;
        }

        String newStr = new String(Arrays.copyOfRange(str, ptr, ptr + subStr.length));
        String newSubStr = new String(subStr);

        System.out.println("Params is : " + newStr + "-" + newSubStr + " " + ptr + " to " + ptr + subStr.length);

        if (newStr.equals(newSubStr)) {
            result = 1;
            result += IsMatch(str, subStr, ptr + subStr.length);
        } else {
            result = 0;
            result += IsMatch(str, subStr, ptr + 1);
        }
        //result += IsMatch(str, subStr, ptr + subStr.length);


        return result;

    }


}