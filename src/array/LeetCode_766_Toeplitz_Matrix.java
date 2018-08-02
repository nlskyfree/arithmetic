package array;

/**
* 题目：Toeplitz Matrix
* A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
* 
* Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
*  
* 
* Example 1:
* 
* Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
* Output: True
* Explanation:
* 1234
* 5123
* 9512
* 
* In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", 
* and in each diagonal all elements are the same, so the answer is True.
* Example 2:
* 
* Input: matrix = [[1,2],[2,2]]
* Output: False
* Explanation:
* The diagonal "[1, 2]" has different elements.
* Note:
* 
* matrix will be a 2D array of integers.
* matrix will have a number of rows and columns in range [1, 20].
* matrix[i][j] will be integers in range [0, 99].
* 思路：前一行前n-1个与当前行后n-1个一样，则满足条件
* @author 倪路
*/
public class LeetCode_766_Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int[] pre = matrix[0];
        for(int i = 1 ; i < matrix.length ; i++) {
            int[] cur = matrix[i];
            for(int j = 0 ; j < matrix[0].length - 1 ; j++) {
                if(pre[j] != cur[j + 1]) {
                    return false;
                }
            }
            pre = cur;
        }
        
        return true;
    }
}
