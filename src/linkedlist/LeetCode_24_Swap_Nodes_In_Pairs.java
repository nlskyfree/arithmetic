package linkedlist;

/**
 * 题目：Swap Nodes In Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 思路：3个指针，记录当前节点，前一节点，后一节点，交换当前节点与后一节点，主要是要注意边界条件
 * @author 倪路
 */
public class LeetCode_24_Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode end = head.next;
        while(true) {
            pre.next = end;
            start.next = end.next;
            end.next = start;
            if(start.next == null || start.next.next == null) {
                break;
            }
            pre = start;
            start = start.next;
            end = start.next;
        }
        
        return dummy.next;
    }
}
