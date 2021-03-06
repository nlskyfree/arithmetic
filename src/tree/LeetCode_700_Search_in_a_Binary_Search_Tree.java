package tree;

/**
* 题目： Search in a Binary Search Tree
* Given the root node of a binary search tree (BST) and a value. 
* You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. 
* If such node doesn't exist, you should return NULL.
* 
* For example, 
* 
* Given the tree:
*         4
*        / \
*       2   7
*      / \
*     1   3
* 
* And the value to search: 2
* You should return this subtree:
* 
*       2     
*      / \   
*     1   3
* In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
* 思路：BST搜索，本质就是二分法
* @author 倪路
*/
public class LeetCode_700_Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) {
                break;
            }
            root = root.val < val ? root.right : root.left;
        }
        
        return root;
    }
}
