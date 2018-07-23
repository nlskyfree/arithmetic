package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：Binary Tree Maximum Path Sum
*  Given a binary tree, write a function to get the maximum width of the given tree. 
* The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, 
* but some nodes are null.
* The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, 
* where the null nodes between the end-nodes are also counted into the length calculation.
* 
* Example 1:
* Input: 
* 
*            1
*          /   \
*         3     2
*        / \     \  
*       5   3     9 
* 
* Output: 4
* Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
* Example 2:
* Input: 
* 
*           1
*          /  
*         3    
*        / \       
*       5   3     
* 
* Output: 2
* Explanation: The maximum width existing in the third level with the length 2 (5,3).
* Example 3:
* Input: 
* 
*           1
*          / \
*         3   2 
*        /        
*       5      
* 
* Output: 2
* Explanation: The maximum width existing in the second level with the length 2 (3,2).
* Example 4:
* Input: 
* 
*           1
*          / \
*         3   2
*        /     \  
*       5       9 
*      /         \
*     6           7
* Output: 8
* Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
* Note: Answer will in the range of 32-bit signed integer.
* 思路：关键是要知道二叉树某节点左右子树的编号为2*parentId,2*parentId+1(数组存树编号)，然后就可得到递归、遍历两种做法
* @author 倪路
*/
public class LeetCode_662_Maximum_Width_of_Binary_Tree {
    
    public int widthOfBinaryTree1(TreeNode root) {
        return widthOfBinaryTree1(root, 0, 1, new ArrayList<>());
    }
    
    public int widthOfBinaryTree1(TreeNode root, int level, int id, List<Integer> leftMost) {
        if(root == null) {
            return 0;
        }
        
        if(level == leftMost.size()) {
            leftMost.add(id);
        }
        int left = widthOfBinaryTree1(root.left, level + 1, id * 2, leftMost);
        int right = widthOfBinaryTree1(root.right, level + 1, id * 2 + 1, leftMost);
        return Math.max(id - leftMost.get(level) + 1, Math.max(left, right));
    }
    
    public int widthOfBinaryTree2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        queue.addFirst(root);
        index.addFirst(1);
        int max = 1;
        while(queue.size() != 0) {
            int size = queue.size();
            int left = index.getLast();
            int right = 0;
            for(int i = 0 ; i < size ; i++) {
                TreeNode temp = queue.removeLast();
                right = index.removeLast();
                if(temp.left != null) {
                    queue.addFirst(temp.left);
                    index.addFirst(2 * right);
                    
                }
                if(temp.right != null) {
                    queue.addFirst(temp.right);
                    index.addFirst(2 * right + 1);
                }
            }
            
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
