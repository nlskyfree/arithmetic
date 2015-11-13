/**
*Given an image represented by an NxNmatrix, where each pixel in the image is
*4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
*place?
*/

public class Question1_6 {
	public static void main(String[] args) {
		char charArray[][] = new char[][] {
			{'1','2','3','4','5'},
			{'6','7','8','9','a'},
			{'b','c','d','e','f'},
			{'g','h','i','j','k'},
			{'l','m','n','o','p'}	
		};
		rotateMatric(charArray);
		for(int i = 0 ; i < charArray.length ; i++) {
			for(int j = 0 ; j < charArray.length ; j++) {
				System.out.print(charArray[i][j]);
			}
			System.out.println();
		}
		
	}

	//时间复杂度O(n^2)，空间复杂度O(n^2)
	public static void rotateMatric(char[][] charArray) {
		//边界条件
		if(charArray == null || charArray.length <= 1) {
			return;
		}
		int width = charArray.length;
		int height = charArray[0].length;
		//行列必须相等
		if(width != height) {
			return;
		}
		
		char temp;
        int n = width - 1;
        for(int i = 0 ; i < width/2 ; i++) {
        	//一定要注意减1！！！！！！！！
            for(int j = i ; j < width - i - 1; j++) {
            	//四条边上的4个点，循环交换位置
                temp = charArray[n-j][i];
                charArray[n-j][i] = charArray[n-i][n-j];
                charArray[n-i][n-j] = charArray[j][n-i];
                charArray[j][n-i] = charArray[i][j];
                charArray[i][j] = temp;
            }
        }
	}
}