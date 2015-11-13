/* Assume you have a method isSubstring which checks if one word is a
*substring of another. Given two strings, si and s2, write code to check if s2 is
*a rotation of si using only one call to isSubstring (e.g.,"waterbottle"is a rotation of "erbottlewat"
*/
public class Question1_8 {
	public static void main(String args[]) {
		System.out.println(isRotation(args[0], args[1]));
	}

	//时间复杂度为O(n*m)
	//空间复杂度为O(n)
    /*
    *If we imagine that s2 is a rotation of si, then we can askwhat the rotation point is. For
    *example, if you rotate waterbottle after wat, you get erbottlewat. In a rotation,we
    *cut si into two parts,x andy, and rearrangethem to get s2.
    *For example:
    *s1 = xy = waterbottle
    *x = wat
    *y = erbottle
    *s2 = yx = erbottlewat
    *yx is always a substring of xyyx
    */
	public static boolean isRotation(String str1, String str2) {
		if(str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		//关键是想到这个，首尾相连
		String tempStr = str1 + str1;
		if(isSubstring(tempStr, str2)) {
			return true;
		} else {
			return false;
		}
	}


	public static boolean isSubstring(String str1, String str2) {
		if(-1 != str1.indexOf(str2)) {
			return true;
		} else {
			return false;
		}
	}
}