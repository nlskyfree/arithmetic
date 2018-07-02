package tree;

/**
* 题目：Trim a Binary Search Tree
* Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). 
* You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
* 
* Example 1:
* Input: 
*     1
*    / \
*   0   2
* 
*   L = 1
*   R = 2
* 
* Output: 
*     1
*       \
*        2
* Example 2:
* Input: 
*     3
*    / \
*   0   4
*    \
*     2
*    /
*   1
* 
*   L = 1
*   R = 3
* 
* Output: 
*       3
*      / 
*    2   
*   /
*  1
* 思路：分治法，若根节点小于L，递归处理右子树，若根节点大于R，递归处理左子树，若根节点在区间内，分别处理左右子树
* @author 倪路
*/
public class LeetCode_669_Trim_a_Binary_Search_Tree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) {
            return root;
        }
        
        if(root.val < L) {
            return trimBST(root.right, L, R);
        } else if(root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, root.val);
            root.right = trimBST(root.right, root.val, R);
            return root;
        }
    }
}
