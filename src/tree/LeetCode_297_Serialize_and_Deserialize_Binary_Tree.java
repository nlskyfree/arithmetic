package tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
* 题目：Serialize and Deserialize Binary Tree
* Serialization is the process of converting a data structure or object into a sequence of bits so 
* that it can be stored in a file or memory  buffer, or transmitted across a network connection link to be reconstructed later 
* in the same or another computer environment.
* 
* Design an algorithm to serialize and deserialize a binary tree. 
* There is no restriction on how your serialization/deserialization algorithm  should work. 
* You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
* 
* Example: 
* 
* You may serialize the following tree:
* 
*     1
*    / \
*   2   3
*      / \
*     4   5
* 
* as "[1,2,3,null,null,4,5]"
* Clarification: The above format is the same as how LeetCode serializes a binary tree.
* You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
* 
* Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
* 思路1：按照leetcode的序列化标准实现，本质是层序遍历
* 思路2：前中后序遍历递归实现
* @author 倪路
*/
public class LeetCode_297_Serialize_and_Deserialize_Binary_Tree {
    public String serialize1(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = queue.removeLast();
                if(node != null) {
                    sb.append(node.val).append(",");
                    queue.addFirst(node.left);
                    queue.addFirst(node.right);
                } else {
                    sb.append("#,");
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if("".equals(data)) {
            return null;
        }
        String[] strs = data.split(",");
        LinkedList<TreeNode> oldQueue = new LinkedList<>();
        for(String str : strs) {
            oldQueue.addFirst("#".equals(str) ? null : new TreeNode(Integer.valueOf(str)));
        }
        TreeNode root = oldQueue.removeLast();
        LinkedList<TreeNode> newQueue = new LinkedList<>();
        newQueue.addFirst(root);
        while(newQueue.size() != 0) {
            TreeNode temp = newQueue.removeLast();
            if(oldQueue.size() != 0) {
                temp.left = oldQueue.removeLast();
                if(temp.left != null) {
                    newQueue.addFirst(temp.left);
                }
            }
            if(oldQueue.size() != 0 ) {
                temp.right = oldQueue.removeLast();
                if(temp.right != null) {
                    newQueue.addFirst(temp.right);
                }
            }
        }
        return root;
    }
    
    // Encodes a tree to a single string.
    public static String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize2(root, sb);
        return sb.substring(0, sb.length() - 1);
    }
    
    public static void serialize2(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#");
            sb.append(",");
            return;
        }
        
        sb.append(root.val);
        sb.append(",");
        serialize2(root.left, sb);
        serialize2(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize2(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize2(queue);
    }
    
    public static TreeNode deserialize2(LinkedList<String> queue) {
        if(queue.size() == 0) {
            return null;
        }
        
        String str = queue.removeFirst();
        if("#".equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserialize2(queue);
        node.right = deserialize2(queue);
        return node;
    }
}
