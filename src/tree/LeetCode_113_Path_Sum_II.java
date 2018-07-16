package tree;

import java.util.ArrayList;
import java.util.List;

/**
* 题目：Path Sum II
* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
* 
* Note: A leaf is a node with no children.
* 
* Example:
* 
* Given the below binary tree and sum = 22,
* 
*       5
*      / \
*     4   8
*    /   / \
*   11  13  4
*  /  \    / \
* 7    2  5   1
* Return:
* 
* [
*    [5,4,11,2],
*    [5,8,4,5]
* ]
* 思路：与112类似，遍历每一步需要记录走过的路径，注意拷贝list
* @author 倪路
*/
public class LeetCode_113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, list, res);
        return res;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        
        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) {
            res.add(newList);
            return;
        }
        
        pathSum(root.left, sum, newList, res);
        pathSum(root.right, sum, newList, res);
    }
}
