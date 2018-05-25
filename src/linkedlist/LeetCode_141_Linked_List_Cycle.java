package linkedlist;

/**
 * 题目：Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * 思路1：用HashSet记录走过的点，再次走过，就有环
 * 思路2： 快慢指针，一个走1步，一个走2步，进入环后，快的必然会多走一圈追上慢指针
 * @author 倪路
 */
public class LeetCode_141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
