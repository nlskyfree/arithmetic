package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：Copy List With Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 思路：1次遍历浅拷贝random，深拷贝其它数据，并建立老节点到新节点的映射关系，再次遍历根据映射表替换random
 * @author 倪路
 */
public class LeetCode_138_Copy_List_With_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        while(head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            tail.next = newNode;
            map.put(head, newNode);
            tail = tail.next;
            head = head.next;
        }
        
        tail = dummy.next;
        while(tail != null) {
            tail.random = map.get(tail.random);
            tail = tail.next;
        }
        return dummy.next;
    }
}
