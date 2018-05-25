package linkedlist;

/**
 * 题目：Remove Duplicates From Sorted List 2
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 思路：双指针，start，end，start待删除链表前一节点，end指向待删除链表尾部，如果待删除链表长度为1，不删除，大于1删除，一直循环
 * @author 倪路
 */
public class LeetCode_82_Remove_Duplicates_From_Sorted_List_2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = head;
        while(end != null) {
            while(end.next != null && end.val == end.next.val) {
                end = end.next;
            }
            if(start.next != end) {
                start.next = end.next;
            } else {
                start = start.next;
            }
            end = end.next;
        }
        return dummy.next;
    }
}
