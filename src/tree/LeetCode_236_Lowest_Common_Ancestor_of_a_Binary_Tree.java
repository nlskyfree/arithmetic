package tree;

/**
* 题目：Lowest Common Ancestor of a Binary Tree
* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
* 
* According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p 
* and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
* 
* Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
* 
*         _______3______
*        /              \
*     ___5__          ___1__
*    /      \        /      \
*    6      _2       0       8
*          /  \
*          7   4
* Example 1:
* Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
* Output: 3
* Explanation: The LCA of of nodes 5 and 1 is 3.
* Example 2:
* 
* Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
* Output: 5
* Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
*              according to the LCA definition.
* Note:
* 
* All of the nodes' values will be unique.
* p and q are different and both values will exist in the binary tree.
* 思路：树的LCA等于，左子树的LCA或右子树的LCA。递归出口，左右为空时，没找到，返回null，左右都有，说明为当前节点，左右有一个，为有的那个
* @author 倪路
*/
public class LeetCode_236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
}
