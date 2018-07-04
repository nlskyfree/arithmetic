package tree;

/**
* 题目：Binary Tree Right Side View
* Given a binary tree
* 
* struct TreeLinkNode {
*   TreeLinkNode *left;
*   TreeLinkNode *right;
*   TreeLinkNode *next;
* }
* Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
* 
* Initially, all next pointers are set to NULL.
* 
* Note:
* 
* You may only use constant extra space.
* Recursive approach is fine, implicit stack space does not count as extra space for this problem.
* Example:
* 
* Given the following binary tree,
* 
*      1
*    /  \
*   2    3
*  / \    \
* 4   5    7
* After calling your function, the tree should look like:
* 
*      1 -> NULL
*    /  \
*   2 -> 3 -> NULL
*  / \    \
* 4-> 5 -> 7 -> NULL
* 思路1：如果不考虑常数空间，中序遍历即可(LeetCode可以过)
* 思路2：与116题相比主要注意调用出口变成判断pre != null，并且循环内需要判断左右子树是否为空
* @author 倪路
*/
public class LeetCode_117_Populating_Next_Right_Pointers_in_Each_Node_II {
    
    public static void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode pre = root;
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode cur = dummy;
        while(pre != null) {
            while(pre != null) {
                if(pre.left != null) {
                    cur.next = pre.left;
                    cur = cur.next;
                }
                if(pre.right != null) {
                    cur.next = pre.right;
                    cur = cur.next;
                }
                pre = pre.next;
            }
            
            pre = dummy.next;
            dummy = new TreeLinkNode(0);
            cur = dummy;
        }
    }
}
