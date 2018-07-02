package tree;

/**
* 题目：Subtree of Another Tree
* Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. 
* The tree s could also be considered as a subtree of itself.
* Example 1:
* Given tree s:
* 
*      3
*     / \
*    4   5
*   / \
*  1   2
* Given tree t:
*    4 
*   / \
*  1   2
* Return true, because t has the same structure and node values with a subtree of s.
* Example 2:
* Given tree s:
* 
*      3
*     / \
*    4   5
*   / \
*  1   2
*     /
*    0
* Given tree t:
*    4
*   / \
*  1   2
* Return false
* 思路：从s的根节点出发，找到与t根节点值相同的点，判断是否为相同的树，是则返回，否则继续找
* 注意：与根节点值相同的点可能不只一个
* @author 倪路
*/
public class LeetCode_572_Subtree_Of_Another_Tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        } else if(s == null || t == null) {
            return false;
        } else if(s.val != t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        // 注意这里，找到相同的点，如果为false还要继续找
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        } else if(s == null || t == null) {
            return false;
        }
        
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
