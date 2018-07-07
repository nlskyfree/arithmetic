package tree;

/**
* 题目：Serialize and Deserialize Binary Tree
* Given inorder and postorder traversal of a tree, construct the binary tree.
* 
* Note:
* You may assume that duplicates do not exist in the tree.
* 
* For example, given
* 
* inorder = [9,3,15,20,7]
* postorder = [9,15,7,20,3]
* Return the following binary tree:
* 
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 思路：和105题对称处理即可
* 注意：从后向前，哨兵为-1
* @author 倪路
*/
public class LeetCode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || (inorder.length != postorder.length)) {
            return null;
        }
        
        return buildTree(inorder, -1, inorder.length - 1, postorder, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int start, int end, int[] postorder, int p) {
        if(start == end) {
            return null;
        }
        int temp = postorder[p];
        TreeNode node = new TreeNode(temp);
        int i = end;
        for(; i > start ; i--) {
            if(inorder[i] == temp) {
                break;
            }
        }
        node.left = buildTree(inorder, start, i - 1, postorder, p - end + i - 1);
        node.right = buildTree(inorder, i, end, postorder, p - 1);
        return node;
    }
}
