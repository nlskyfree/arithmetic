package tree;

/**
* 题目：Diameter of Binary Tree
* Given a binary tree, you need to compute the length of the diameter of the tree. 
* The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
* This path may or may not pass through the root.
* 
* Example:
* Given a binary tree 
*           1
*          / \
*         2   3
*        / \     
*       4   5    
* Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
* 
* Note: The length of path between two nodes is represented by the number of edges between them.
* 思路1：分治法，直径=Math.max(包含root的最大直径, Math.max(左子树直径，右子树直径))
* 思路2：改进思路1，思路1中存在左右子树直径的重复计算，递归了2次，思路2就是将左右子树直径的计算合并到对包含root最大直径的计算中
* @author 倪路
*/
public class LeetCode_543_Diameter_of_Binary_Tree {
    public int diameterOfBinaryTree1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int r = depth1(root.left) + depth1(root.right);
        int left = diameterOfBinaryTree1(root.left);
        int right = diameterOfBinaryTree1(root.right);
        return Math.max(r, Math.max(left, right));
    }
    
    public int depth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth1(root.left);
        int right = depth1(root.right);
        return Math.max(left, right) + 1;
    }
    
    public int diameterOfBinaryTree2(TreeNode root) {
        int[] max = new int[]{0};
        depth2(root, max);
        return max[0];
    }
    
    public int depth2(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int left = depth2(root.left, max);
        int right = depth2(root.right, max);
        if(left + right > max[0]) {
            max[0] = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
