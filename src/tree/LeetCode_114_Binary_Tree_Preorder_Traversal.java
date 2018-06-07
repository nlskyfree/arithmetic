package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 * 1
 *  \
 *   2
 *  /
 * 3
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * @author 倪路
 */
public class LeetCode_114_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
