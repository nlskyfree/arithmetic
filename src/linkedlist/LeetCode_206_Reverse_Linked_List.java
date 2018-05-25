package linkedlist;

/**
 * 题目：Reverse Linked List
 * Reverse a singly linked list.
 * 思路1：产生新链表，dummy节点指向null，遍历链表，把每个节点插入dummy节点和下一节点之间
 * 思路2：就地，dummy指向head，遍历链表，把head的next插入dummy节点和下一节点之间
 * @author 倪路
 */
public class LeetCode_206_Reverse_Linked_List {
    public ListNode reverseList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        while(head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        
        return dummy.next;
    }
    
    public ListNode reverseList2(ListNode head) {
        if(head == null) {
            return head; 
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        
        return dummy.next;
    }
}
