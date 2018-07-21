package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 题目：Most Frequent Subtree Sum
* Given the root of a tree, you are asked to find the most frequent subtree sum. T
* he subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). 
* So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
* 
* Examples 1
* Input:
* 
*   5
*  /  \
* 2   -3
* return [2, -3, 4], since all the values happen only once, return all of them in any order.
* Examples 2
* Input:
* 
*   5
*  /  \
* 2   -5
* return [2], since 2 happens twice, however -5 only occur once.
* Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
* 思路：遍历计算每个点的sum值，统计一下即可。吐槽：java转换int[]真是麻烦
* @author 倪路
*/
public class LeetCode_508_Most_Frequent_Subtree_Sum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] max = new int[]{Integer.MIN_VALUE};
        computeTreeSum(root, countMap, max);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer sum = entry.getKey();
            Integer count = entry.getValue();
            if(count == max[0]) {
                res.add(sum);
            }
        }
        
        int[] arr = new int[res.size()];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = res.get(i);
        }
        
        return arr;
    }
    
    public int computeTreeSum(TreeNode root, Map<Integer, Integer> countMap, int[] max) {
        if(root == null) {
            return 0;
        }
        
        int left = computeTreeSum(root.left, countMap, max);
        int right = computeTreeSum(root.right, countMap, max);
        int num = left + right + root.val;
        int count = 1;
        if(countMap.containsKey(num)) {
            count = countMap.get(num) + 1;
        }
        countMap.put(num, count);
        
        if(count > max[0]) {
            max[0] = count;
        }
        return num;
    }
}
