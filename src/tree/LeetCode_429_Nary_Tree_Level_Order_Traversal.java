package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：Second Minimum Node In a Binary Tree
* Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
* Note:
* 
* The depth of the tree is at most 1000.
* The total number of nodes is at most 5000.
* 思路：和二叉树层序遍历一致，递归，迭代两种实现
* @author 倪路
*/
public class LeetCode_429_Nary_Tree_Level_Order_Traversal {
    
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder1(root, 0, res);
        return res;
    }
    
    public void levelOrder1(Node root, int level, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        
        if(res.size() <= level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        } else {
            res.get(level).add(root.val);
        }
        List<Node> children = root.children;
        if(children != null) {
            for(Node child : children) {
                levelOrder1(child, level + 1, res);
            }
        }
    }
    
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        while(queue.size() != 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++) {
                Node node = queue.removeLast();
                list.add(node.val);
                List<Node> children = node.children;
                if(children != null) {
                    for(Node child : children) {
                        queue.addFirst(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
