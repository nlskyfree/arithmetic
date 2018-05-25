package linkedlist;

/**
 * 题目：Remove Duplicates From Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 思路：双指针，cur，next，每次判断cur，next值是否相等，相等删除next指向节点，不相等，cur，next各移动一步
 * @author 倪路
 */
public class LeetCode_83_Remove_Duplicates_From_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null) {
            if(cur.val == next.val) {
                cur.next = next.next;
                next = cur.next;
            } else {
                cur = next;
                next = next.next;
            }
        }
        
        return head;
    }
}
