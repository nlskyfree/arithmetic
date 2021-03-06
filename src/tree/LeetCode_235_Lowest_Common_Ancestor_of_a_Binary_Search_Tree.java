package tree;

/**
* 题目：Lowest Common Ancestor of a Binary Search Tree 
* Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
* According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
* that has both p and q as descendants (where we allow a node to be a descendant of itself).”
* 
* Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
* 
*         _______6______
*        /              \
*     ___2__          ___8__
*    /      \        /      \
*    0      _4       7       9
*          /  \
*          3   5
* Example 1:
* 
* Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
* Output: 6
* Explanation: The LCA of nodes 2 and 8 is 6.
* Example 2:
* 
* Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
* Output: 2
* Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
*              according to the LCA definition.
* Note:
* 
* All of the nodes' values will be unique.
* p and q are different and both values will exist in the BST.
* 思路：从根节点出发，若根节点等于两个节点中任意一个或根节点在区间范围内，则命中返回，若根节点小于左值，则公共祖先在右子树，根节点大于右值，同理
* @author 倪路
*/
public class LeetCode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            TreeNode temp = q;
            q = p;
            p = temp;
        }
        while(root != null) {
            if(root == p || root == q) {
                break;
            }
            
            if(root.val < p.val) {
                root = root.right;
            } else if(root.val > q.val) {
                root = root.left;
            } else {
                break;   
            }
        }
        
        return root;
    }
}
