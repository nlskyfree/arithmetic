package linkedlist;

/**
 * 题目：Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input. 
 * The first node is considered odd, the second node even and so on ...
 * 思路：遍历奇数放到奇链表，偶数放到偶链表，奇链表尾部接上偶链表头部
 * @author 倪路
 */
public class LeetCode_328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        boolean flag = false;
        ListNode odd = new ListNode(0);
        ListNode tailOdd = odd;
        ListNode even = new ListNode(0);
        ListNode tailEven = even;
        while(head != null) {
            ListNode next = head.next;
            if(flag) {
                tailEven.next = head;
                tailEven = head;
                flag = true;
            } else {
                tailOdd.next = head;
                tailOdd = head;
                flag = false;
            }
            head.next = null;
            head = next;
        }
        
        tailOdd.next = even.next;
        return odd.next;
    }
}
