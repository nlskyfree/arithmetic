package linkedlist;

/**
 * 题目：Merge K Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 思路1：每次遍历数组中所有链表，取最小值放入新链表，一直遍历直到所有链表都到尾部（缺点：多执行了非常多无意义的判空逻辑）
 * 思路2：每2个链表进行合并(一个到达尾部，可以直接拼接另外一个链表剩余部分，无需判空)
 * @author 倪路
 */
public class LeetCode_23_Merge_K_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode[] dummys = new ListNode[lists.length];
        for(int i = 0 ; i < lists.length ; i++) {
            dummys[i] = new ListNode(0);
            dummys[i].next = lists[i];
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(true) {
            int min = -1;
            for(int i = 0 ; i < lists.length ; i++) {
                if(dummys[i].next == null) {
                    continue;
                }
                
                if(min == -1 || dummys[i].next.val < dummys[min].next.val) {
                    min = i;
                }
            }
            
            if(min == -1) {
                break;
            }
            tail.next = dummys[min].next;
            tail = tail.next;
            dummys[min].next = dummys[min].next.next;
        }
        
        return dummy.next;
    }
}
