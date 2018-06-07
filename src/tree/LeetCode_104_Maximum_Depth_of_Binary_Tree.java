package tree;

/**
 * 题目：Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 思路：2个链表同时遍历，结点不为空则值相加并加上上一步的进位，计算下一步的进位
 * 重点： 注意保留进位信息，如果链表一样长，最后的进位可能会产生新节点
 * @author 倪路
 */
public class LeetCode_104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return (left > right ? left : right) + 1;
    }
}
