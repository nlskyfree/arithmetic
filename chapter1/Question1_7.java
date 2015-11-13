/*Write an algorithm such that if an element in an MxN matrix is 0, its entire row
*and column are set to 0.
*/
public class Question1_7 {
	public static void main(String args[]) {
		int array[][] = new int[][] {
			{1,2,3,4,5,7},
			{6,7,8,0,5,6},
			{0,3,0,3,2,5},
			{1,2,4,66,1,4},
			{12,5,23,2,0,3}	
		};
		setZeros(array);
		for(int i = 0 ; i < array.length ; i++) {
			for(int j = 0 ; j < array[0].length ; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	//记录行号、列号，最后一次性赋值
	//时间复杂度为O(n^2)，已达到最优（考虑全为非0的情况，每个数都至少遍历一次）
	//空间复杂度为O(n)
	public static void setZeros(int array[][]) {
		if(array == null || array.length <= 1) {
			return;
		}
		int width = array.length;
		int height = array[0].length;
		//boolean数组默认为false
		boolean rowNumRecord[] = new boolean[width];
		boolean columnNumRecord[] = new boolean[height];
		for(int i = 0 ; i < width ; i++) {
			for(int j = 0 ; j < height ; j++) {
				if(array[i][j] == 0) {
                    //下面的判断是多余的
					//if(!rowNumRecord[i]) {
						rowNumRecord[i] = true;
					//}
					//if(!columnNumRecord[j]) {
						columnNumRecord[j] = true;
					//}
				}
			}
		}

		for(int i = 0 ; i < width ; i++) {
			for(int j = 0 ; j < height ; j++) {
				if(rowNumRecord[i] || columnNumRecord[j]) {
					array[i][j] = 0;
				}
			}
		}
	} 
}