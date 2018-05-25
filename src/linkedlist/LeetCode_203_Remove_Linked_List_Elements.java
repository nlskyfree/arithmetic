package linkedlist;

/**
 * 题目：Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * 思路：遍历链表，记录前一节点，当前节点值为val，则删除
 * @author 倪路
 */
public class LeetCode_203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null) {
            if(head.val == val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}
