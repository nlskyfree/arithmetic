package tree;

import java.util.LinkedList;

/**
* 题目：Binary Tree Maximum Path Sum
* Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
* 
* Calling next() will return the next smallest number in the BST.
* 
* Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
* 思路：中序遍历
* @author 倪路
*/
public class LeetCode_173_Binary_Search_Tree_Iterator {

    LinkedList<TreeNode> stack;

    public LeetCode_173_Binary_Search_Tree_Iterator(TreeNode root) {
        stack = new LinkedList<>();
        pushToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.removeFirst();
        pushToStack(node.right);
        
        return node.val;
    }
    
    private void pushToStack(TreeNode root) {
        while(root != null) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
