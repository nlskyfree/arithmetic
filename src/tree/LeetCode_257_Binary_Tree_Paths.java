package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 思路：本质为二叉树的前序遍历
 * @author 倪路
 */
public class LeetCode_257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        traverse(root, "", result);
        return result;
    }
    
    public void traverse(TreeNode root, String path, List<String> result) {
        String temp = "".equals(path) ? String.valueOf(root.val) : path + "->" + root.val;
        if(root.left == null && root.right == null) {
            result.add(temp);
        }
        
        if(root.left != null) {
            traverse(root.left, temp, result);
        }
        
        if(root.right != null) {
            traverse(root.right, temp, result);
        }
    }
}
