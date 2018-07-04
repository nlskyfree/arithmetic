package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：Binary Tree Right Side View
* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
* 
* Example:
* 
* Input: [1,2,3,null,5,null,4]
* Output: [1, 3, 4]
* Explanation:
* 
*    1            <---
*  /   \
* 2     3         <---
*  \     \
*   5     4       <---
* 思路：层序遍历每层取队列尾部加入结果集即可
* @author 倪路
*/
public class LeetCode_199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(queue.size() != 0) {
            int size = queue.size();
            res.add(queue.getFirst().val);
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
        return res;
    }
}
