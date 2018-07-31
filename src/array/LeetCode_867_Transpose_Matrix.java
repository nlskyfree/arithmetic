package array;

import java.util.Arrays;

/**
* 题目：Transpose Matrix
* Given a matrix A, return the transpose of A.
* The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
* Example 1:
* 
* Input: [[1,2,3],[4,5,6],[7,8,9]]
* Output: [[1,4,7],[2,5,8],[3,6,9]]
* Example 2:
* 
* Input: [[1,2,3],[4,5,6]]
* Output: [[1,4],[2,5],[3,6]]
* Note:
* 
* 1 <= A.length <= 1000
* 1 <= A[0].length <= 1000
* 思路：转置即交换横纵坐标，注意数组的长宽转置后也可能改变
* @author 倪路
*/
public class LeetCode_867_Transpose_Matrix {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] res = new int[n][m];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
