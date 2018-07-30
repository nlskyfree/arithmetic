package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* 题目：All Nodes Distance K in Binary Tree
* We are given a binary tree (with root node root), a target node, and an integer value `K`.
* 
* Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
* Example 1:
* 
* Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
* Output: [7,4,1]
* Explanation: 
* The nodes that are a distance 2 from the target node (with value 5)
* have values 7, 4, and 1.
* 
* Note that the inputs "root" and "target" are actually TreeNodes.
* The descriptions of the inputs above are just serializations of these objects.
* 
* Note:
* 
* The given tree is non-empty.
* Each node in the tree has unique values 0 <= node.val <= 500.
* The target node is a node in the tree.
* 0 <= K <= 1000.
* 思路：本质是从target点出发图结构的BFS，关键是怎么记录图结构，这里用一个Map记录，也可以存储在节点上
* @author 倪路
*/
public class LeetCode_863_All_Nodes_Distance_K_in_Binary_Tree {
    
    private Map<TreeNode, List<TreeNode>> nodeMap = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        buildMap(root, null);
        Set<TreeNode> exists = new HashSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(target);
        exists.add(target);
        while(queue.size() != 0) {
            int size = queue.size();
            if(K-- == 0) {
                for(TreeNode node : queue) {
                    res.add(node.val);
                }
                return res;
            }
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = queue.removeLast();
                for(TreeNode temp : nodeMap.get(node)) {
                    if(exists.contains(temp)) {
                        continue;
                    }
                    exists.add(temp);
                    queue.addFirst(temp);
                }
            }
        }
        
        return res;
    }
    
    private void buildMap(TreeNode root, TreeNode parent) {
        if(root == null) {
            return;
        }
        
        List<TreeNode> childs = new ArrayList<>();
        if(root.left != null) {
            childs.add(root.left);
            buildMap(root.left, root);
        }
        if(root.right != null) {
            childs.add(root.right);
            buildMap(root.right, root);
        }
        if(parent != null) {
            childs.add(parent);
        }
        nodeMap.put(root, childs);
    }
}
