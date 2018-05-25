package linkedlist;

/**
 * 题目：Reverse Node in a Linked List
 * 思路：值交换，下个值存到当前节点，删除下个节点
 * @author 倪路
 */
public class LeetCode_237_Delete_Node_In_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
