package tree;

/**
* 题目：Longest Univalue Path
* Given a binary tree, find the length of the longest path where each node in the path has the same value. 
* This path may or may not pass through the root.
* 
* Note: The length of path between two nodes is represented by the number of edges between them.
* 
* Example 1:
* 
* Input:
* 
*               5
*              / \
*             4   5
*            / \   \
*           1   1   5
* Output:
* 
* 2
* Example 2:
* 
* Input:
* 
*               1
*              / \
*             4   5
*            / \   \
*           4   4   5
* Output:
* 
* 2
* Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
* 思路1：与543题二叉树直径思路一样，思路1直观分支法
* 思路2：自底向上思考，叶子节点处最长同值路径为0，倒数第二层，如果左节点等于当前节点+1，则左子树同值路径+1，右节点等于当前节点再+1，则右子树同值路径+1，
*      当前节点最长同值路径为左子树+右子树，与max比较，再返回Math.max(左子树同值最长同值路径，右子树最长同值路径)，以此向上推导
* @author 倪路
*/
public class LeetCode_687_Longest_Univalue_Path {
    public int longestUnivaluePath1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int r = helper1(root.left, root.val) + helper1(root.right, root.val);
        int left = longestUnivaluePath1(root.left);
        int right = longestUnivaluePath1(root.right);
        return Math.max(r, Math.max(left, right));
    }
    
    public int helper1(TreeNode root, int val) {
        if(root == null || root.val != val) {
            return 0;
        }
        
        int left = helper1(root.left, val);
        int right = helper1(root.right, val);
        return Math.max(left, right) + 1;
    }
    
    public int longestUnivaluePath2(TreeNode root) {      
        int[] max = new int[]{0};
        helper2(root, max);
        return max[0];
    }
    
    public int helper2(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int left = helper2(root.left, max) + 1;
        int right = helper2(root.right, max) + 1;
        left = root.left != null && root.val == root.left.val ? left : 0;
        right = root.right != null && root.val == root.right.val ? right : 0;
        max[0] = Math.max(max[0], left + right);
        
        return Math.max(left, right);
    }
}
