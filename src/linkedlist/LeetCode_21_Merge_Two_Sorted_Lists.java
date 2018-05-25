package linkedlist;

/**
 * 题目：Merge Two Sorted List
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 思路：遍历+比较，放入新链表即可，较长的链表剩余部分最后放到新链表尾部
 * @author 倪路
 */
public class LeetCode_21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if(l1 != null) {
            tail.next = l1;
        }
        
        if(l2 != null) {
            tail.next = l2;
        }
        
        return dummy.next;
    }
}
