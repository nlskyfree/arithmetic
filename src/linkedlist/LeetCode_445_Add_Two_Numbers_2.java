package linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：Add Two Numbers II
 *  You are given two non-empty linked lists representing two non-negative integers. 
 *  The most significant digit comes first and each of their nodes contain a single digit. 
 *  Add the two numbers and return it as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *  Follow up:
 *  What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 思路1：先reverse链表1，再reverse链表2，然后安装Add Two Numbers的思路，最后reverse最终结果即可
 * 思路2：考虑不改变链表大小，可使用2个栈来完成逆序相加
 * 重点： 注意保留进位信息，如果链表一样长，最后的进位可能会产生新节点
 * @author 倪路
 */
public class LeetCode_445_Add_Two_Numbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> l3 = new LinkedList<>();
        Deque<Integer> l4 = new LinkedList<>();
        while(l1 != null) {
            l3.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            l4.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode dummy = new ListNode(0);
        int incr = 0;
        while(l3.size() != 0 || l4.size() != 0) {
            int val = incr;
            if(l3.size() != 0) {
                val += l3.pop();
            }
            if(l4.size() != 0) {
                val += l4.pop();
            }
            incr = val / 10;
            val = val % 10;
            
            ListNode temp = new ListNode(val);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        
        if(incr != 0) {
            ListNode temp = new ListNode(incr);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        
        return dummy.next;
    }
}
