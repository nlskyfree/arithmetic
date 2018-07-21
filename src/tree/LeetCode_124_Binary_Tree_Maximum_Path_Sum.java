package tree;

/**
* 题目：Binary Tree Maximum Path Sum
* Given a non-empty binary tree, find the maximum path sum.
* 
* For this problem, a path is defined as any sequence of nodes from some starting node to any node 
* in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
* 
* Example 1:
* 
* Input: [1,2,3]
* 
*        1
*       / \
*      2   3
* 
* Output: 6
* Example 2:
* 
* Input: [-10,9,20,null,null,15,7]
* 
*    -10
*    / \
*   9  20
*     /  \
*    15   7
* 
* Output: 42
* 思路：自底向上，左右子树为负则舍弃左右子树的值，每个节点判断左+右+当前值是否为max
* 注意：root.val为负不能舍弃，因为路径不能断开
* @author 倪路
*/
public class LeetCode_124_Binary_Tree_Maximum_Path_Sum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }
    
    public int maxPathSum(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        int sum = left + right + root.val;
        if(sum > max[0]) {
            max[0] = sum;
        }
        return Math.max(left, right) + root.val;
    }
}
