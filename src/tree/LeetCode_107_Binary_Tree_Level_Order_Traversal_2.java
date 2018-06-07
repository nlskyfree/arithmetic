package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：Binary Tree Level Order Traversal 2
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 思路：层次遍历，插入时，通过链表操作逆序插入即可
 * @author 倪路
 */
public class LeetCode_107_Binary_Tree_Level_Order_Traversal_2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<List<Integer>> res = new LinkedList<>();
        while(queue.size() != 0) {
            int level = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < level ; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.addFirst(temp);
        }
        
        return res;
    }
}
