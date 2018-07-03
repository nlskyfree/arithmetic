package tree;

import java.util.LinkedList;

/**
* 题目：Find Bottom Left Tree Value
* Given a binary tree, find the leftmost value in the last row of the tree.
* 
* Example 1:
* Input:
* 
*     2
*    / \
*   1   3
* 
* Output:
* 1
* Example 2: 
* Input:
* 
*         1
*        / \
*       2   3
*      /   / \
*     4   5   6
*        /
*       7
* 
* Output:
* 7
* Note: You may assume the tree (i.e., the given root node) is not NULL.
* 思路1：中序遍历，最后一层第一个即为结果
* 思路2：前中后序遍历，任一方式都可保证同层最左边的数是最先遍历到的，所以只要记录depth，找导maxDepth中第一个被遍历的节点即可
* @author 倪路
*/
public class LeetCode_513_Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue1(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        TreeNode first = null;
        while(queue.size() != 0) {
            int size = queue.size();
            first = queue.getLast();
            for(int i = 0 ; i < size ; i++) {
                TreeNode temp = queue.removeLast();
                if(temp.left != null) {
                    queue.addFirst(temp.left);
                }
                if(temp.right != null) {
                    queue.addFirst(temp.right);
                }
            }
        }
        
        return first.val;
    }
    
    int maxDepth = -1;
    int leftVal = 0;
    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 1);
        return leftVal;
    }
    
    public void helper(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        
        if(depth > maxDepth) {
            leftVal = root.val;
            maxDepth = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
