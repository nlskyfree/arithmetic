package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：Binary Tree Inorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 * 1
 *  \
 *   2
 *  /
 * 3
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * @author 倪路
 */
public class LeetCode_94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
