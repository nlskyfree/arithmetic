package tree;

/**
 * @file BST.java 创建时间:2018年6月13日上午11:35:55
 * @description 二叉搜索树的搜索、添加、删除
 * @author 倪路
 * @version 1.0
 *
 */
public class BST {
    private TreeNode parent;
    
    public TreeNode deleteNode(TreeNode root, int key) {
        parent = new TreeNode(Integer.MIN_VALUE);
        parent.left = root;
        deleteNodeHelper(parent.left, key);
        return parent.left;
    }
    
    public void deleteNodeHelper(TreeNode root, int key) {
        TreeNode node = searchBST(root, key);
        if(node == null) {
            return;
        }
        
        if(node.left != null && node.right != null) {
            TreeNode start = node.right;
            TreeNode pStart = node;
            while(start.left != null) {
                pStart = start;
                start = start.left;
            }
            
            node.val = start.val;
            if(pStart == node) {
                pStart.right = start.right;
            } else {
                pStart.left = start.right;
            }
        } else if(node.left != null) {
            if(node.val < parent.val) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if(node.right != null) {
            if(node.val < parent.val) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {
            if(node.val < parent.val) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else if(root.val == val) {
            return root;
        }
        
        parent = root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
