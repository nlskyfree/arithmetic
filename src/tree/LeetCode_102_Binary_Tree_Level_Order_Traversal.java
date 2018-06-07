package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：Binary Tree Level Order Traversal
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
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 思路：使用队列，遍历当前层时把下一层所有节点按序加入队列，当前队列中的数据为所有下一层的数据。因为每次需要清空当前层，因此需要两层循环
 * @author 倪路
 */
public class LeetCode_102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        
        while(queue.size() != 0) {
            List<Integer> nodes = new ArrayList<>();
            int level = queue.size();
            for(int i = 0 ; i < level ; i++) {
                TreeNode temp = queue.poll();
                nodes.add(temp.val);
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(nodes);
        }
        return result;
    }
}
