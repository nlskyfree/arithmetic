package tree;

public class LeetCode_450_Delete_Node_In_a_BST {
    // 解法1
    private TreeNode parent;
    
    public TreeNode deleteNode1(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;
        parent = dummy;
        deleteNodeHelper(root, key);
        return dummy.left;
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
    
    // 解法2
    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null) {
            return null;
        } 
        
        if(key < root.val) {
            root.left = deleteNode2(root.left, key);
            return root;
        } else if(key > root.val) {
            root.right = deleteNode2(root.right, key);
            return root;
        } else {
            if(root.left == null) {
                return root.right;
            }
            
            if(root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }

            root.val = node.val;
            root.right = deleteNode2(root.right, node.val);
            return root;
        }
    }
    
    // 解法3
    public TreeNode deleteNode3(TreeNode root, int key) {
        if(root == null) {
            return null;
        } 
        
        if(key < root.val) {
            root.left = deleteNode3(root.left, key);
            return root;
        } else if(key > root.val) {
            root.right = deleteNode3(root.right, key);
            return root;
        } else {
            if(root.left == null) {
                return root.right;
            }
            
            if(root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }

            if(parent == null) {
                node.left = root.left;
                return node;
            }

            parent.left = node.right;
            node.left = root.left;
            node.right = root.right;
            return node;
        }
    }
}
