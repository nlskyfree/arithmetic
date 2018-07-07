package tree;

/**
* 题目：Serialize and Deserialize Binary Tree
* Given preorder and inorder traversal of a tree, construct the binary tree.
*Note:
*You may assume that duplicates do not exist in the tree.
*
*For example, given
*
*preorder = [3,9,20,15,7]
*inorder = [9,3,15,20,7]
*Return the following binary tree:
*
*    3
*   / \
*  9  20
*    /  \
*    15   7
* 思路：任意一颗子树，前序遍历第一个为根节点，后面接着左子树，再后面是右子树，但是不知道左右子树分界线。而考虑中序遍历，根节点在中间，左边是左子树，右边是右子树。
*     因此，通过前序序列得到root，然后再中序序列中记录找到root所走的step，即可确定前序左右子树的分界线，同时中序遍历的左右子树分界线自然可知。递归处理即可。
* @author 倪路
*/
public class LeetCode_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || (preorder.length != inorder.length)) {
            return null;
        }
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }
    
    public TreeNode buildTree(int[] preorder, int p, int[] inorder, int start, int end) {
        if(start == end) {
            return null;
        }
        
        int temp = preorder[p];
        int i = start;
        TreeNode node = new TreeNode(temp);
        for(; i < end ; i++) {
            if(inorder[i] == temp) {
                break;
            }
        }
        node.left = buildTree(preorder, p + 1, inorder, start, i);
        node.right = buildTree(preorder, p + i - start + 1, inorder, i + 1, end);
        return node;
    }
}
