package linkedlist;

/**
 * 题目：Reverse Node in k-group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * 思路：1、计算链表长度，判断可以分为count个kgroup
 * 2、循环count次，每次反转k个节点
 * @author 倪路
 */
public class LeetCode_25_Reverse_Node_In_Kgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        if(count < k) {
            return head;
        }
        count = count / k;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode realHead = dummy;
        ListNode next = head.next;
        while(count-- != 0) {
            int tmp = k;
            while(--tmp != 0) {
                head.next = next.next;
                next.next = realHead.next;
                realHead.next = next;
                next = head.next;
            }
            
            if(next == null || next.next == null) {
               break; 
            }
            realHead = head;
            head = next;
            next = head.next;
        }
        return dummy.next;
    }
}
