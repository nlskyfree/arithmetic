package tree;

/**
* 题目：Count Complete Tree Nodes
* Given a complete binary tree, count the number of nodes.
* 
* Note:
* 
* Definition of a complete binary tree from Wikipedia: 
* In a complete binary tree every level, except possibly the last, is completely filled, 
* and all nodes in the last level are as far left as  possible. It can have between 1 and 2h nodes inclusive at the last level h.
* 
* Example:
* 
* Input: 
*     1
*    / \
*   2   3
*  / \  /
* 4  5 6
* 
* Output: 6
* 思路：由于遍历一次O(n)超时了，因此推测时间复杂度需要O(logn)，说明每次需要将问题规模减半，考虑到满二叉树可O(1)计算出节点个数，而完全二叉树左右子树必然有一个为满二叉树
*     通过判断最左节点深度与最右节点深度是否相同，可判断该树是否为满二叉树
* @author 倪路
*/
public class LeetCode_222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        TreeNode lr = root, rr = root;
        int left = 0, right = 0;
        while(lr != null) {
            lr = lr.left;
            left++;
        }
        
        while(rr != null) {
            rr = rr.right;
            right++;
        }
        
        if(left == right) {
            return (1 << left) - 1;
        }
        
        left = countNodes(root.left);
        right = countNodes(root.right);
        return left + right + 1;
    }
}
