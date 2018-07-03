package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* 题目：Trim a Binary Search Tree
*  Given a Binary Search Tree and a target number, return true if there exist two elements in the BST 
* such that their sum is equal to the given  target.
* Example 1:
* Input: 
*     5
*    / \
*   3   6
*  / \   \
* 2   4   7
* 
* Target = 9
* 
* Output: True
* Example 2:
* Input: 
*     5
*    / \
*   3   6
*  / \   \
* 2   4   7
* 
* Target = 28
* 
* Output: False
* 思路：1、遍历，构建HashSet，遍历获取val，再找k-val 2、中序遍历，双指针夹逼
* @author 倪路
*/
public class LeetCode_653_Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        traverse(root, set);
        
        for(Integer val : set) {
            int temp = k - val;
            if(temp != val && set.contains(temp)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void traverse(TreeNode root, Set<Integer> set) {
        if(root == null) {
            return;
        }
        set.add(root.val);
        traverse(root.left, set);
        traverse(root.right, set);
    }
    
    
    
    
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int start = 0;
        int end = list.size() - 1;
        while(start != end) {
            int temp = list.get(start) + list.get(end);
            if(temp == k) {
                return true;
            } else if(temp > k) {
                end--;
            } else {
                start++;
            }
        }
        
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
