package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：Linked List Components 
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * Note:
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 * 思路：用HashSet存储G，遍历链表，每发现一个连续区别则count++
 * @author 倪路
 */
public class LeetCode_817_Linked_List_Components {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        Set<Integer> gSet = new HashSet<>();
        for(int g : G) {
            gSet.add(g);
        }
        boolean flag = false;
        while(head != null && gSet.size() != 0) {
            if(gSet.contains(head.val)) {
                flag = true;
            } else if(flag) {
                count++;
                flag = false;
            }
            head = head.next;
        }
        
        if(flag) {
            count++;
        }
        return count;
    }
}
