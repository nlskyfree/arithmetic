package tree;

/**
* 题目：Path Sum III
* You are given a binary tree in which each node contains an integer value.
* Find the number of paths that sum to a given value.
* The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
* The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
* Example:
* 
* root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
* 
*       10
*      /  \
*     5   -3
*    / \    \
*   3   2   11
*  / \   \
* 3  -2   1
* 
* Return 3. The paths that sum to 8 are:
* 
* 1.  5 -> 3
* 2.  5 -> 2 -> 1
* 3. -3 -> 11
* 思路：减而治之，问题同等于以当前节点开头为sum的路径数加上左子树为sum的路径数与右子树为sum的路径数
*     以当前节点开头为sum的路径数，与Path Sum I类似，可直接计算得出，从而使得问题的规模减一
* @author 倪路
*/
public class LeetCode_437_Path_Sum_III {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathSumHelper(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        sum -= root.val;
        if(sum == 0) {
            count++;
        }
        return count + pathSumHelper(root.left, sum) + pathSumHelper(root.right, sum);
    }
}
