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
* You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
* Example:
* 
* Given the following perfect binary tree,
* 
*      1
*    /  \
*   2    3
*  / \  / \
* 4  5  6  7
* After calling your function, the tree should look like:
* 
*      1 -> NULL
*    /  \
*   2 -> 3 -> NULL
*  / \  / \
* 4->5->6->7 -> NULL
* 思路1：如果不考虑常数空间，中序遍历即可(LeetCode可以过)
* 思路2：考虑完全二叉树必有左右节点，通过遍历上一层链表，取左右节点，构建下层链表
* 注意：类中next默认初始化为null，因此不用显示设置链表尾为null
* @author 倪路
*/
public class LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node {
    public void connect1(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode pre = root;
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode cur = dummy;
        while(pre.left != null) {
            while(pre != null) {
                cur.next = pre.left;
                cur = cur.next;
                cur.next = pre.right;
                cur = cur.next;
                pre = pre.next;
            }
            pre = dummy.next;
            dummy = new TreeLinkNode(0);
            cur = dummy;
        }
    }
    
    public static void connect2(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left != null) {
            cur = pre;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}
