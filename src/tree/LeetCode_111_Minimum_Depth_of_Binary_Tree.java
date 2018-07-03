package tree;

/**
* 题目：Minimum Depth of Binary Tree
* Given a binary tree, find its minimum depth.
* 
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* 
* Note: A leaf is a node with no children.
* 
* Example:
* 
* Given binary tree [3,9,20,null,null,15,7],
* 
*     3
*    / \
*   9  20
*     /  \
*    15   7
* return its minimum depth = 2.
* 思路：分治递归，只有左子树，等于左子树+1，只有右子树，等于右子树+1，有左右子树，等于min(left, right) + 1
* @author 倪路
*/
public class LeetCode_111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            return 1;
        } else if(root.left == null) {
            return minDepth(root.right) + 1;
        } else if(root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
}
