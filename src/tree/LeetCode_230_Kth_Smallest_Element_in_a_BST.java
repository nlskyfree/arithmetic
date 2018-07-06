package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：Kth Smallest Element in a BST
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* 
* Note: 
* You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
* 
* Example 1:
* 
* Input: root = [3,1,4,null,2], k = 1
*    3
*   / \
*  1   4
*   \
*    2
* Output: 1
* Example 2:
* 
* Input: root = [5,3,6,2,4,null,null,1], k = 3
*        5
*       / \
*      3   6
*     / \
*    2   4
*   /
*  1
* Output: 3
* Follow up:
* What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
* How would you optimize the kthSmallest routine?
* 思路：中序遍历获取第k个节点即可
* @author 倪路
*/
public class LeetCode_230_Kth_Smallest_Element_in_a_BST {
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    public static int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        fillStack(root, stack);
        int count = 1;
        while(stack.size() != 0) {
            TreeNode node = stack.removeFirst();
            if(count++ == k) {
                return node.val;
            }
            fillStack(node.right, stack);
        }
        
        return -1;
    }
    
    public static void fillStack(TreeNode root, LinkedList<TreeNode> stack) {
        while(root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
