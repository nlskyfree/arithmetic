//Implement a function void reverse(char* str) in C or C++ which reverses a nullterminated string.


public class Question1_2 {
	public static void main(String[] args) {
		System.out.println(args[0]);
		char[] charArray = args[0].toCharArray();
		reverse(charArray);
		System.out.println(new String(charArray));
	}

	public static void reverse(char[] charArray) {
		if(null == charArray || charArray.length <= 1) {
			return;
		}
		int firstIndex = 0;
		int lastIndex = charArray.length - 1;

		char temp;
		do {
			temp = charArray[firstIndex];
			charArray[firstIndex] = charArray[lastIndex];
			charArray[lastIndex] = temp;
			System.out.println(temp);
		} while(++firstIndex <= --lastIndex);
	}
}