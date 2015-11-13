/**
*Implement a method to perform basic string compression using the counts
*of repeated characters. For example, the string aabcccccaaa would become
*a2blc5a3. If the "compressed"string would not become smaller than the original string, your method should return the original string.
*/

public class Question1_5 {
	public static void main(String[] args) {
		// String str = compressA(args[0]);
		// System.out.println(str);
		String str = compressB(args[0]);
		System.out.println(str);
	}
	
	//if allow to use String?StringBuffer?StringBuilder?
    //time complexity O(n), space complexity O(n)
	public static String compressA(String str) {
		if(str == null || str.length() <= 2) {
			return str;
		}
		char curChar = str.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < str.length() ; i++) {
			if(curChar == str.charAt(i)) {
				count++;
			} else {
				sb.append(curChar);
				sb.append(count);
				curChar = str.charAt(i);
				count = 1;
			}
		}
		sb.append(curChar);
		sb.append(count);
		if(sb.length() >= str.length()) {
			return str;
		} else {
			return sb.toString();
		}
	}

    public static void compressB(char[] charArray) {
        if(str == null || charArray.length <= 2) {
            return;
        }
        int length = getCompressLength(charArray);
        if(count >= charArray.length) {
            return;
        }
        char[] tempArray = new char[length];
        char lastChar = charArray[0];
        int count = 1;
        int index = 0;
        for(int i = 1 ; i < charArray.length ; i++) {
            if(charArray[i] == lastChar) {
                count++;
            } else {
                index = copyChars(tempArray, lastChar, index, count);
                lastChar = charArray[i];
                count = 1;
            }
        }
        copyChars(tempArray, lastChar, index, count);
    }

    public static int getCompressLength(char[] charArray) {
        int count = 0;
        int tempCount = 1;
        char lastChar = charArray[0];
        for(int i = 1 ; i < charArray.length ; i++) {
            if(charArray[i] == lastChar) {
                tempCount++;
            } else {
                count += 1 + String.valueOf(tempCount).length;
                lastChar = charArray[i];
                tempCount = 1;
            }
        }
        count = count + 1 + String.valueOf(tempCount).length;
        return count;
    }

    public static int copyChars(char[] charArray, char ch, int index, int count) {
        charArray[index++] = ch;
        char[] tempArray = String.valueOf(count).toCharArray();
        for(char c : tempArray) {
            charArray[index++] = c;
        }
        return index;
    }
}