package tree;

/**
* 题目：Serialize and Deserialize Binary Tree
* Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
* 
* Example:
* 
* Input: 3
* Output: 5
* Explanation:
* Given n = 3, there are a total of 5 unique BST's:
* 
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*     /     /       \                 \
*    2     1         2                 3
* 思路：递归+查表
* @author 倪路
*/
public class LeetCode_96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        return numTrees(n, new int[n]);
    }
    
    public int numTrees(int n, int[] a) {
        int sum = 0;
        for(int i = 1 ; i <= n ; i++) {
            int left, right;
            if(a[i - 1] != 0) {
                left = a[i - 1];
            } else {
                left = numTrees(i - 1, a);
                a[i - 1] = left;
            }
            if(a[n - i] != 0) {
                right = a[n - i];
            } else {
                right = numTrees(n - i, a);
                a[n - i] = right;
            }
            sum += left * right;
        }
        
        return sum == 0 ? 1 : sum;
    }
}
