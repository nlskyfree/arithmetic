/**
*Write a method to replace all spaces in a string with'%20'. You may assume that
*the string has sufficient space at the end of the string to hold the additional
*characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
*EXAMPLE
*Input: "Mr John Smith
*Output: "Mr%20Dohn%20Smith"
*/

public class Question1_4 {
	public static void main(String[] args) {
		String str = "Mr John Smith";
        char[] charArray = new char[str.length + 4];
        for(int i = 0 ; i < str.length() ; i++) {
            charArray[i] = str.charAt(i);
        }
    	char[] charArray = replaceSpaces(charArray, str.length);
		System.out.println(new String(charArray));
	}

	//time complexity O(n)，space complexity O(1)
	public static void replaceSpaces(char[] charArray, int length) {
        if(charArray == null || charArray.length <= 0) {
            return;
        }
        //get number of spaces
        int count = 0;
        for(int i = 0 ; i < length ; i++) {
            if(' ' == charArray[i]) {
                count++;
            }
        }
        int realEndIndex = length;
        int endIndex = length + count * 2;
        while(--realEndIndex >= 0) {
            if(' ' == charArray[realEndIndex]) {
                charArray[--endIndex] = '0'; 
                charArray[--endIndex] = '2'; 
                charArray[--endIndex] = '%'; 
            } else {
                charArray[--endIndex] = charArray[realEndIndex]; 
            }
        }
	}
}