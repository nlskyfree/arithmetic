package linkedlist;

/**
 * 题目：Reverse Linked List 2
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 思路：移动到m-1的位置，反转n-m个节点即可
 * @author 倪路
 */
public class LeetCode_92_Reverse_Linked_List_2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mhead = dummy;
        // 移动到开始节点的前一节点
        int a = m - 1;
        while(a-- != 0) {
            mhead = mhead.next;
        }
        
        ListNode pre = mhead.next;
        ListNode cur = pre.next;
        int b = n - m;
        while(b-- != 0) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = mhead.next;
            mhead.next = temp;
        }
        
        return dummy.next;
    }
}
