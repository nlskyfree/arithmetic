package linkedlist;

/**
 * 题目：Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 思路：2个链表同时遍历，结点不为空则值相加并加上上一步的进位，计算下一步的进位
 * 重点： 注意保留进位信息，如果链表一样长，最后的进位可能会产生新节点
 * @author 倪路
 */
public class LeetCode_2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int incr = 0;
        while(l1 != null || l2 != null) {
            int val = incr;
            if(l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            incr = val / 10;
            val = val % 10;
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        
        if(incr != 0) {
            tail.next = new ListNode(incr);   
        }
        return dummy.next;
    }
}
