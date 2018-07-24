package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 题目：Binary Tree Maximum Path Sum
* Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
* you only need to return the root node of any one of them.
* 
* Two trees are duplicate if they have the same structure with same node values.
* 
* Example 1:
* 
*         1
*        / \
*       2   3
*      /   / \
*     4   2   4
*        /
*       4
* The following are two duplicate subtrees:
* 
*       2
*      /
*     4
* and
* 
*     4
* Therefore, you need to return above trees' root in the form of a list.
* 思路：关键是要想到序列化所有节点对应的子树，O(n^2)，再想到序列化根节点时，其实已经序列化了左右子树，可进一步改为O(n)复杂度
* 注意：中序遍历不能做序列化，考虑[0,0,0,0,null,null,0,null,null,null,0]，#0#0#左右两边的树深为2的计算结果一样
* @author 倪路
*/
public class LeetCode_652_Find_Duplicate_Subtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> nodes = new ArrayList<>();
        serial(root, map, nodes);
        return nodes;
    }
    
    public String serial(TreeNode root, Map<String, Integer> map, List<TreeNode> nodes) {
        if(root == null) {
            return "#";
        }
        
        String left = serial(root.left, map, nodes);
        String right = serial(root.right, map, nodes);
        String cur = left + right + root.val;
        if(map.containsKey(cur)) {
            int val = map.get(cur);
            if(val == 1) {
                nodes.add(root);
            }
            map.put(cur, val + 1);
        } else {
            map.put(cur, 1);
        }
        return cur;
    }
}
