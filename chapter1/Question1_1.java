/*
*Implement an algorithm to determine if a string has all unique characters. What if you
*can not use additional data structures?
*/

public class Question1_1{
	public static void main(String[] args) {
		boolean a = isUniquedStringA(args[0]);
		System.out.println(a);
		boolean b = isUniquedStringB(args[0]);
		System.out.println(b);
	}

	//减而治之，从最后一个字符起，若其不在前1，n-1个字符中，继续，直到n=1
	//总共需递归调用n-1次，分别需循环判断n-1, n-2, .... 1次，因此时间复杂度为O(n^2)
	public static boolean isUniquedStringA(String str) {
		if(null == str || str.length()<= 1) {
	       	return true;
		}
		if(-1 != str.substring(0, str.length() - 1).indexOf(str.substring(str.length() - 1))) {
			return false;
		} else {
			return isUniquedStringA(str.substring(0, str.length() - 1));
		}
	}

	//从第一个字符起，循环判断是否在后面字符串中
	//时间复杂度为O(n^2)
	public static boolean isUniquedStringB(String str) {
		if(null == str || str.length()<= 1) {
			return true;
		}
		int length = str.length();
		for(int i = 0 ; i < length - 1 ; i++) {
			if(-1 != str.substring(i+1).indexOf(str.substring(i, i+1))) {
				return false;
			}
		}
		return true;

	}

	//time complexity is O(n), space complexity is O(n)
	public static boolean isUniquedStringC(String str) {
		if(null == str || str.length() < =1) {
			return true;
		}
		if(str.length() > 256) {
			return false;
		}
		boolean table[] = new boolean[256];//default value is false for boolean array
		for(char ch : str.toCharArray()) {
			if(table[ch]) {
				return false;
			} else {
				table[ch] = true;
			}
		}
		return true;
	}

	//assume that str is consist of 'a'-'z'
	//use bit array to store status
	public static boolean isUniquedStringD(String str) {
		if(null == str || str.length <= 1) {
			return true;
		}
		int flag = 0;
		int bit;
		for(int i = 0 ; i < str.length() ; i++) {
			bit = str.charAt(i) - 'a';
			if( flag & (1 << bit) > 0) 
				return false;
			}
			flag |= 1 << bit;
		}
		return true;
	}
}