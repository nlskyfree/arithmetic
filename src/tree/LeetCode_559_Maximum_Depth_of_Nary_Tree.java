package tree;

import java.util.List;

/**
* 题目：Second Minimum Node In a Binary Tree
* Given a n-ary tree, find its maximum depth.
* 
* The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
* 
* Note:
* 
* The depth of the tree is at most 1000.
* The total number of nodes is at most 5000.
* 思路，分治，所有子树中最大值+1
* @author 倪路
*/
public class LeetCode_559_Maximum_Depth_of_Nary_Tree {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        
        List<Node> children = root.children;
        int max = 0;
        if(children != null) {
           for(Node child : children) {
                int depth = maxDepth(child);
                if(depth > max) {
                    max = depth;
                }
            }
        }
        return max + 1;
    }
}
