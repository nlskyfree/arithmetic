package linkedlist;

/**
 * 题目：Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 思路：1、快慢指针，一个走1步，1个走两步，慢指针达到中间点(注意边界条件，要求前半部分长)
 * 2、翻转后半部分
 * 3、组装新链表，2个链表交替取node
 * @author 倪路
 */
public class LeetCode_143_Reorder_List {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode l1 = head, l2 = head;
        while(l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
        }
        
        // 翻转后面的链表
        ListNode l3 = l1;
        l1 = reverse(l1.next);
        l3.next = null;
        // 组装新链表
        while(l1 != null) {
            ListNode temp = l1.next;
            l1.next = head.next;
            head.next = l1;
            head = l1.next;
            l1 = temp;
        }
    }
    
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while(head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
