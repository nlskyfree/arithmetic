package tree;

/**
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * 思路：关键是记录当前节点为上一节点的左儿子吗
 * @author 倪路
 */
public class LeetCode_404_Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return traverse(root, false);
    }
    
    public int traverse(TreeNode root, boolean flag) {
        if(root.left == null && root.right == null && flag) {
            return root.val;
        }
        
        int sum = 0;
        if(root.left != null) {
            sum += traverse(root.left, true);
        }
        if(root.right != null) {
            sum += traverse(root.right, false);
        }
        return sum;
    }
}
