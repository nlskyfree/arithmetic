package linkedlist;

/**
 * 题目：Intersection of Two Linked List
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 思路：l1走到头，从l2开始走，l2走到头从l1开始走，必然在第一个相遇点相遇
 * @author 倪路
 */
public class LeetCode_160_Intersection_of_Two_Linked_List {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
