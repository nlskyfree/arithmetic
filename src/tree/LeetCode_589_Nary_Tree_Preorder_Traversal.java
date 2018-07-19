package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 题目：N-ary Tree Preorder Traversal
* Given an n-ary tree, return the preorder traversal of its nodes' values.
* Note: Recursive solution is trivial, could you do it iteratively?
* 思路：和二叉树前序遍历一致，递归、迭代两种思路
* @author 倪路
*/
public class LeetCode_589_Nary_Tree_Preorder_Traversal {
    
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    
    public void preorder(Node root, List<Integer> res) {
        if(root == null) {
            return;
        }
        
        res.add(root.val);
        List<Node> children = root.children;
        if(children != null) {
            for(Node child : children) {
                preorder(child, res);
            }
        }
    }
    
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        LinkedList<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while(stack.size() != 0) {
            Node node = stack.removeFirst();
            res.add(node.val);
            List<Node> children = node.children;
            if(children != null && children.size() != 0) {
                for(int i = children.size() - 1 ; i >= 0 ; i--) {
                    stack.addFirst(children.get(i));
                }
            }
        }
        return res;
    }
}
