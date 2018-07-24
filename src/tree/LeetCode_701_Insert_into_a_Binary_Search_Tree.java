package tree;

/**
* 题目：Insert into a Binary Search Tree
* Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. 
* Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
* 
* Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
* 
* For example, 
* 
* Given the tree:
*         4
*        / \
*       2   7
*      / \
*     1   3
* And the value to insert: 5
* You can return this binary search tree:
* 
*          4
*        /   \
*       2     7
*      / \   /
*     1   3 5
* This tree is also valid:
* 
*          5
*        /   \
*       2     7
*      / \   
*     1   3
*          \
*           4
* 思路：一种思路2种写法都是搜索树，找到待插入位置的父节点，根据父节点与待插入节点的相对大小，插入节点
* @author 倪路
*/
public class LeetCode_701_Insert_into_a_Binary_Search_Tree {
    TreeNode parent;
    
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) {
            return node;
        }
        
        helper1(root, val);
        if(parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return root;
    }
    
    public void helper1(TreeNode root, int val) {
        if(root == null) {
            return;
        }
        parent = root;
        helper1(root.val < val ? root.right : root.left, val);
    }
    
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null) {
            return root;
        }
        
        if(root.val < val) {
            if(root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST2(root.right, val);
            }
        } else {
            if(root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST2(root.left, val);
            }
        }
        
        return root;
    }
}
