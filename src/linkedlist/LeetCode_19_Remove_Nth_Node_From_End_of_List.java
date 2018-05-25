package linkedlist;

/**
 * 题目：Remove Nth Node From End of
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 * 思路：l1先走n+1步，l2在走，找到倒数第n+1个点，删除倒数第n个点
 * @author 倪路
 */
public class LeetCode_19_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy, l2 = dummy;
        n++;
        while(n-- != 0) {
            l1 = l1.next;
        }
        
        while(l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        
        return dummy.next;
    }
}
