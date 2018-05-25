package linkedlist;

/**
 * 题目：Split Linked List In Parts
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * Return a List of ListNode's representing the linked list parts that are formed.
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Note:
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 * 思路：1、计算链表长度num
 * 2、计算每个区间的长度，和有多少个比其它区间大1的区间
 * 3、遍历，按照区间长度装入链表
 * @author 倪路
 */
public class LeetCode_725_Split_Linked_List_In_Parts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode temp = root;
        int num = 0;
        while(temp != null){
            temp = temp.next;
            num++;
        }
        
        int len = num / k;
        int count = num % k;
        ListNode[] res = new ListNode[k];
        int step = len;
        for(int i = 0 ; i < Math.min(num, k) ; i++) {       
            if(count != 0) {
                step++;
                count--;
            }
            
            res[i] = root;
            ListNode dummy = new ListNode(0);
            dummy.next = root;
            root = dummy;
            while(step-- != 0) {
                root = root.next;
            }
            step = len;
            temp = root.next;
            root.next = null;
            root = temp;
        }
        
        return res;
    }
}
