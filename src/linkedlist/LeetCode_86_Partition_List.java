package linkedlist;

/**
 * 题目：Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 思路：遍历链表，小于x的放到链表1，大于等于的放到链表2，链表1的尾部连接到链表2即可
 * @author 倪路
 */
public class LeetCode_86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode heads = s;
        ListNode headb = b;
        while(head != null) {
            if(head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        
        b.next = null;
        s.next = headb.next;
        return heads.next;
    }
}
