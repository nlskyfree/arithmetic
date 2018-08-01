package array;

import java.util.ArrayList;
import java.util.List;

/**
* 题目：Pascals Triangle II
* Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
* 
* Note that the row index starts from 0.
* In Pascal's triangle, each number is the sum of the two numbers directly above it.
* 
* Example:
* 
* Input: 3
* Output: [1,3,3,1]
* Follow up:
* 
* Could you optimize your algorithm to use only O(k) extra space?
* @author 倪路
*/
public class LeetCode_119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = null;
        for(int i = 0 ; i < rowIndex + 1 ; i++) {
            List<Integer> cur = new ArrayList<>();
            for(int j = 0 ; j < i + 1 ; j++) {
                if(j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }
}
