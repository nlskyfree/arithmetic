package tree;

/**
 * 题目：Merge Two Binary Trees
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * Example 1:
 * Input: 
 *  Tree 1                     Tree 2                  
 *           1                         2                             
 *          / \                       / \                            
 *         3   2                     1   3                        
 *        /                           \   \                      
 *       5                             4   7                  
 * Output: 
 * Merged tree:
 *       3
 *      / \
 *     4   5
 *    / \   \ 
 *   5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 * 思路：分治法， 合并树等于合并当前节点，合并左子树，合并右子树，注意，t1,t2左右子树有一个为空时可以直接取另一棵树的左右子树接到返回树上
 * @author 倪路
 */
public class LeetCode_617_Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node = null;
        if(t1 != null && t2 != null) {
            node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
        } else if(t1 != null) {
            return t1;
        } else if(t2 != null) {
            return t2;
        }
        return node;
    }
}
