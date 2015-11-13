//Given two strings, write a method to decide if one is a permutation of the other.

public class Question1_3 {
	public static void main(String args[]) {
		System.out.println(isPermutationB(args[0], args[1]));
	}
	//即str1中每个字符在str2中都存在，并且数目一致
	//时间复杂度为O(nlogn)（基本取决于排序算法，equals为O(n)）
	//空间复杂度为O(n+m)，存储排序后的String
	public static boolean isPermutationA(String str1, String str2) {
		if(null == str1 || null == str2 || str1.length() != str2.length()) {
			return false;
		}
		//按编码值排序
		//String本质是字符数组，实际也是比较每个字符，时间复杂度为O(n)
		return sort(str1).equals(sort(str2));
	}

	//solution
	//Assume that charset is ASCII
	public static boolean isPermutationB(String str1, String str2) {
		if(null == str1 || null == str2 || str1.length() != str2.length()) {
			return false;
		}
		int[] count = new int[256];//the length depend on the size of charset
		for(char ch : str1.toCharArray()) {
			count[ch]++;
		}

		for(char ch : str2.toCharArray()) {
			if(--count[ch] < 0) {
				return false;
			}
		}
		return true;
	}

	public static String sort(String str) {
		if(null == str || str.length() <= 1) {
			return str;
		}
		//冒泡排序，可替换为别的排序，改善效率
		char[] charArray = str.toCharArray();
		boolean isSorted = false;
		char temp;
		int n = str.length();
		while(!isSorted) {
			isSorted = true;
			for(int i = 1 ; i < n ; i++) {
				if(charArray[i-1] > charArray[i]) {
					temp = charArray[i-1];
					charArray[i-1] = charArray[i];
					charArray[i] = temp;
					isSorted = false;
				}
			}
			n--;
		}
		return new String(charArray);
	}
}