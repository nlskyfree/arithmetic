package tree;

/**
* 题目：Smallest Subtree with all the Deepest Nodes
* Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
* A node is deepest if it has the largest depth possible among any node in the entire tree.
* The subtree of a node is that node, plus the set of all descendants of that node.
* Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
* Example 1:
* 
* Input: [3,5,1,6,2,0,8,null,null,7,4]
* Output: [2,7,4]
* Explanation:
* 
* 
* 
* We return the node with value 2, colored in yellow in the diagram.
* The nodes colored in blue are the deepest nodes of the tree.
* The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
* The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
* Both the input and output have TreeNode type.
*  
* 
* Note:
* 
* The number of nodes in the tree will be between 1 and 500.
* The values of each node are unique.
* 思路：当一棵树左子树高度等于右子树时，显然应该返回root，否则舍弃高度较低的子树，继续判断高度较高的树，再尝试将这个想法自底向上构建，从而一次遍历得到结果
* @author 倪路
*/
public class LeetCode_865_Smallest_Subtree_with_all_the_Deepest_Nodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return (TreeNode)helper(root)[0];
    }
    
    public Object[] helper(TreeNode root) {
        if(root == null) {
            return new Object[]{null, 0};
        }
        
        Object[] left = helper(root.left);
        Object[] right = helper(root.right);
        int leftHeight = (int)left[1];
        int rightHeight = (int)right[1];
        TreeNode leftNode = (TreeNode)left[0];
        TreeNode rightNode = (TreeNode)right[0];
        if(leftHeight == rightHeight) {
            return new Object[]{root, leftHeight + 1};
        } else if(leftHeight > rightHeight) {
            return new Object[]{leftNode, leftHeight + 1};
        } else {
            return new Object[]{rightNode, rightHeight + 1};
        }
    }
}
