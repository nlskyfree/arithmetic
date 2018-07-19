package tree;

/**
* 题目：Second Minimum Node In a Binary Tree
* Given a non-empty special binary tree consisting of nodes with the non-negative value, 
* where each node in this tree has exactly two or zero  sub-node. 
* If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
* 
* Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
* 
* If no such second minimum value exists, output -1 instead.
* 
* Example 1:
* Input: 
*     2
*    / \
*   2   5
*      / \
*     5   7
* 
* Output: 5
* Explanation: The smallest value is 2, the second smallest value is 5.
* Example 2:
* Input: 
*     2
*    / \
*   2   2
* 
* Output: -1
* Explanation: The smallest value is 2, but there isn't any second smallest value.
* 思路：因为根节点肯定最小，只需遍历找到不等于根节点且最小的节点即可
* @author 倪路
*/
public class LeetCode_671_Second_Minimum_Node_In_a_Binary_Tree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        int min = root.val;
        int[] second = new int[]{Integer.MAX_VALUE};
        findSecond(root, min, second);
        return second[0] == Integer.MAX_VALUE ? -1 : second[0];
    }
    
    public void findSecond(TreeNode root, int min, int[] second) {
        if(root == null) {
            return;
        }
        
        if(root.val != min && root.val < second[0]) {
            second[0] = root.val;
        }
        findSecond(root.left, min, second);
        findSecond(root.right, min, second);
    }
}
