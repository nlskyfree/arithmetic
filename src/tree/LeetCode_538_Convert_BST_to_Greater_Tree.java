package tree;

/**
* 题目：Convert BST to Greater Tree
*  Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST 
*  is changed to the original key plus sum of all keys greater than the original key in BST.
* 
* Example:
* 
* Input: The root of a Binary Search Tree like this:
*               5
*             /   \
*            2     13
* 
* Output: The root of a Greater Tree like this:
*              18
*             /   \
*           20     13
* 思路：利用搜索树的特性，左子树<节点<右子树，考虑当前节点，左子树，右子树的值如何计算即可
* @author 倪路
*/
public class LeetCode_538_Convert_BST_to_Greater_Tree {
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }
    
    public int convertBST(TreeNode root, int big) {
        if(root == null) {
            return 0;
        }
        
        int temp = root.val;
        int right = convertBST(root.right, big);
        root.val = root.val + big + right;
        int left = convertBST(root.left, root.val);
        return left + right + temp;
    }
}
