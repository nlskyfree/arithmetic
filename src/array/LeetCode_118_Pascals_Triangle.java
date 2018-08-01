package array;

import java.util.ArrayList;
import java.util.List;

/**
* 题目：Pascal's Triangle
* Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
* 
* In Pascal's triangle, each number is the sum of the two numbers directly above it.
* 
* Example:
* 
* Input: 5
* Output:
* [
*      [1],
*     [1,1],
*    [1,2,1],
*   [1,3,3,1],
*  [1,4,6,4,1]
* ]
* @author 倪路
*/
public class LeetCode_118_Pascals_Triangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) {
            return res;
        }
        
        for(int i = 0 ; i < numRows ; i++) {
            List<Integer> cur = new ArrayList<>();
            for(int j = 0 ; j < i + 1 ; j++) {
                if(j == 0 || j == i) {
                    cur.add(1);
                } else {
                    List<Integer> pre = res.get(i - 1);
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(cur);
        }
        
        return res;
    }
}
