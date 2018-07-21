package tree;

import java.util.LinkedList;

/**
* 题目：Sum Root to Leaf Numbers
* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
* 
* An example is the root-to-leaf path 1->2->3 which represents the number 123.
* 
* Find the total sum of all root-to-leaf numbers.
* 
* Note: A leaf is a node with no children.
* 
* Example:
* 
* Input: [1,2,3]
*     1
*    / \
*   2   3
* Output: 25
* Explanation:
* The root-to-leaf path 1->2 represents the number 12.
* The root-to-leaf path 1->3 represents the number 13.
* Therefore, sum = 12 + 13 = 25.
* Example 2:
* 
* Input: [4,9,0,5,1]
*     4
*    / \
*   9   0
*  / \
* 5   1
* Output: 1026
* Explanation:
* The root-to-leaf path 4->9->5 represents the number 495.
* The root-to-leaf path 4->9->1 represents the number 491.
* The root-to-leaf path 4->0 represents the number 40.
* Therefore, sum = 495 + 491 + 40 = 1026.
* Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
* 思路1：记录走过的路径，到叶子节点后拼接成数加到结果集
* 思路2：优化思路1中每次递归需要存储路径，直接在递归过程中进行计算，到叶子节点得到结果
* @author 倪路
*/
public class LeetCode_129_Sum_Root_to_Leaf_Numbers {
    public int sumNumbers1(TreeNode root) {
        int[] max = new int[]{0};
        sumNumbers1(root, new LinkedList<>(), max);
        return max[0];
    }
    
    public void sumNumbers1(TreeNode root, LinkedList<Integer> nums, int[] max) {
        if(root == null) {
            return;
        }
        
        nums.addFirst(root.val);
        if(root.left == null && root.right == null) {
            int size = nums.size();
            for(int i = 0 ; i < size ; i++) {
                max[0] += nums.removeFirst() * Math.pow(10, i);
            }
        }
        
        sumNumbers1(root.left, new LinkedList<>(nums), max);
        sumNumbers1(root.right, new LinkedList<>(nums), max);
    }
    
    public int sumNumbers2(TreeNode root) {
        int[] max = new int[]{0};
        sumNumbers2(root, 0, max);
        return max[0];
    }
    
    public void sumNumbers2(TreeNode root, int num, int[] max) {
        if(root == null) {
            return;
        }
        
        num = num * 10 + root.val;
        if(root.left == null && root.right == null) {
            max[0] += num;
        }
        
        sumNumbers2(root.left, num, max);
        sumNumbers2(root.right, num, max);
    }
}
