package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：Find Largest Value in Each Tree Row
* You need to find the largest value in each row of a binary tree.
* 
* Example:
* Input: 
* 
*           1
*          / \
*         3   2
*        / \   \  
*       5   3   9 
* 
* Output: [1, 3, 9]
* 思路1：中序遍历，每层计算最大值
* 思路2：分治递归，本质是遍历所有节点，记录每个节点所属层数，然后算最大值
* @author 倪路
*/
public class LeetCode_515_Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(queue.size() != 0) {
            int size = queue.size();
            int max = queue.getLast().val;
            for(int i = 0 ; i < size ; i++) {
                TreeNode temp = queue.removeLast();
                if(temp.val > max) {
                     max = temp.val;
                }
                if(temp.left != null) {
                    queue.addFirst(temp.left);
                }
                if(temp.right != null) {
                    queue.addFirst(temp.right);
                }
            }
            res.add(max);
        }
        return res;
    }
    
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largestValues2(root, 0, res);
        return res;
    }
    
    public void largestValues2(TreeNode root, int height, List<Integer> res) {
        if(root == null) {
            return;
        }
        
        if(res.size() <= height) {
            res.add(root.val);
        } else if(res.get(height) < root.val) {
            res.set(height, root.val);
        }
        largestValues2(root.left, height + 1, res);
        largestValues2(root.right, height + 1, res);
    }
}
