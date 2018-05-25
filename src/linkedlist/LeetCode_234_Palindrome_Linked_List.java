package linkedlist;

/**
 * 题目：Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome. 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 思路1：暴力破解，得到链表的长度，双重遍历解决
 * 思路2： 链表对半分，后面部分翻转，然后遍历判等
 * @author 倪路
 */
public class LeetCode_234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode countList = head;
        // 统计长度
        int count = 0;
        while(countList != null) {
            count++;
            countList = countList.next;
        }
        
        // 链表划分成2段
        count = (count + 1) / 2;
        ListNode mid = head;
        while(count-- != 0) {
            mid = mid.next;
        }
        
        // 翻转
        ListNode dummy = new ListNode(0);
        while(mid != null) {
            ListNode temp = mid.next;
            mid.next = dummy.next;
            dummy.next = mid;
            mid = temp;
        }
        
        mid = dummy.next;
        while(mid != null) {
            if(head.val != mid.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
}
