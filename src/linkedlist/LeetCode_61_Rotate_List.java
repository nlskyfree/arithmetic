package linkedlist;

/**
 * 题目：Rotate list
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 思路：1、计算链表长度；2、长度-k对长度求余为从头到断点前一节点的长度；3、记录新的头结点，从断开点断开
 * 重点：将链表头与尾连接成环，找到断开点，断开后即得到结果
 * @author 倪路
 */
public class LeetCode_61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        // 判断链表长度
        int count = 1;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }
        k = count - k % count;
        temp.next = head;
        // 找到断开位置
        while(k-- != 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
