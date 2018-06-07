package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：Binary Tree Postorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 * 1
 *  \
 *   2
 *  /
 * 3
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * @author 倪路
 */
public class LeetCode_145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
    
    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
