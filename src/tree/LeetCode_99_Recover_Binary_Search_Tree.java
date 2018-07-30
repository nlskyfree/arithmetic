package tree;

import java.util.LinkedList;

/**
* 题目：Recover Binary Search Tree
* Two elements of a binary search tree (BST) are swapped by mistake.
* 
* Recover the tree without changing its structure.
* 
* Example 1:
* 
* Input: [1,3,null,null,2]
* 
*    1
*   /
*  3
*   \
*    2
* 
* Output: [3,1,null,null,2]
* 
*    3
*   /
*  1
*   \
*    2
* Example 2:
* 
* Input: [3,1,4,null,null,2]
* 
*   3
*  / \
* 1   4
*    /
*   2
* 
* Output: [2,1,4,null,null,3]
* 
*   2
*  / \
* 1   4
*    /
*   3
* Follow up:
* 
* A solution using O(n) space is pretty straight forward.
* Could you devise a constant space solution?
* 思路1： 中序遍历，得到结果，然后排序，再中序遍历，将值重新set一遍，时间复杂度O(nlogn)，空间复杂度O(n)
* 思路2：题目中提到2个点被交换，导致BST错误，因此思考如何找到这2个点，考虑中序遍历，从头到尾遍历即可找到位置不对的两个节点，注意考虑2个点中序顺序上挨着的特殊情况
* @author 倪路
*/
public class LeetCode_99_Recover_Binary_Search_Tree {
    public void recoverTree1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder1(root, list);
        list.sort(null);
        recover1(root, list);
    }
    
    public void inorder1(TreeNode root, LinkedList<Integer> list) {
        if(root == null) {
            return;
        }
        
        inorder1(root.left, list);
        list.add(root.val);
        inorder1(root.right, list);
    }
    
    public void recover1(TreeNode root, LinkedList<Integer> list) {
        if(root == null) {
            return;
        }
        
        recover1(root.left, list);
        root.val = list.removeFirst();
        recover1(root.right, list);
    }
    
    TreeNode pre, first, second;
    public void recoverTree2(TreeNode root) {
        inorder2(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorder2(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inorder2(root.left);
        if(first == null && pre != null && pre.val > root.val) {
            first = pre;
        }
        
        if(first != null && pre.val > root.val) {
            second = root;
        }
        pre = root;
        inorder2(root.right);
    }
}
