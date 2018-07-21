package tree;

/**
* 题目：House Robber III
* The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." 
* Besides the root, each house has one and only one parent house. After a tour, 
* the smart thief realized that "all houses in this place forms a binary tree". 
* It will automatically contact the police if two directly-linked houses were broken into on the same night.
* 
* Determine the maximum amount of money the thief can rob tonight without alerting the police.
* 
* Example 1:
*      3
*     / \
*    2   3
*     \   \ 
*      3   1
* Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
* Example 2:
*      3
*     / \
*    4   5
*   / \   \ 
*  1   3   1
* Maximum amount of money the thief can rob = 4 + 5 = 9.
* 思路1：问题可以等价于Math.max(打劫root，不打劫root)，但是由于递归过程中存在大量重复计算，性能较低
* 思路2：将包含当前值与不包含当前值的计算放在一个递归中计算，返回值0为包含当前层的最大值，返回值1为最大值(因为第n层的最大值计算依赖于n+1包含当前层的最大值)
* @author 倪路
*/
public class LeetCode_337_House_Robber_III {
    public int rob1(TreeNode root) {  
        int robRootVal = robRoot1(root);
        int notRobRootVal = notRobRoot1(root);
        return Math.max(robRootVal, notRobRootVal);
    }
    
    public int robRoot1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = notRobRoot1(root.left);
        int right = notRobRoot1(root.right);

        return left + right + root.val;
    }
    
    public int notRobRoot1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftRob = robRoot1(root.left);
        int leftNotRob = notRobRoot1(root.left);
        int rightRob = robRoot1(root.right);
        int rightNotRob = notRobRoot1(root.right);
        return Math.max(leftRob, leftNotRob) + Math.max(rightRob, rightNotRob);
    }
    
    public int rob2(TreeNode root) {  
        return robHelper2(root)[1];
    }
    
    public int[] robHelper2(TreeNode root) {
        int[] res = new int[]{0, 0};
        if(root == null) {
            return res;
        }
        
        int[] left = robHelper2(root.left);
        int[] right = robHelper2(root.right);
        res[0] = left[1] + right[1];
        res[1] = Math.max(res[0], left[0] + right[0] + root.val);
        return res;
    }
}
