package linkedlist;

/**
 * 题目：Linked List Cycle 2
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * 思路1：用HashSet记录走过的点，再次走过的第一个节点，就是入环点
 * 思路2： 快慢指针，一个走1步，一个走2步，相遇后，一个指针移动到head，再各自走一步，再次相遇为入环点
 * @author 倪路
 */
public class LeetCode_142_Linked_List_Cycle_2 {
    public ListNode detectCycle(ListNode head) {
        ListNode l1 = head, l2 = head;
        
        while(l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if(l1 == l2) {
                l1 = head;
                while(true) {
                    if(l1 == l2) {
                        return l1;
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
        }
        return null;
    }
}
