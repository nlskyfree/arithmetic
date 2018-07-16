package tree;

/**
* 题目：Flatten Binary Tree to Linked List
* Given a binary tree, flatten it to a linked list in-place.
* 
* For example, given the following tree:
* 
*     1
*    / \
*   2   5
*  / \   \
* 3   4   6
* The flattened tree should look like:
* 
* 1
*  \
*   2
*    \
*     3
*      \
*       4
*        \
*         5
*          \
*           6
* 思路：题目有一点没描述清楚是，必须都为右子树并且必须按照前序遍历的顺序构造链表；将左子树挂到右子树，右子树挂到左子树最右边即可
* @author 倪路
*/
public class LeetCode_114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode start = root.right;
            while(start.right != null) {
                start = start.right;
            }
            start.right = temp;
        }
        flatten(root.right);
    }
}
