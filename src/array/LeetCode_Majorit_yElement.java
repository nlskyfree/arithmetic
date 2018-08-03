package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* 题目：TMajority Element
* Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
* 
* You may assume that the array is non-empty and the majority element always exist in the array.
* 
* Example 1:
* 
* Input: [3,2,3]
* Output: 3
* Example 2:
* 
* Input: [2,2,1,1,1,2,2]
* Output: 2
* 思路1：排序取第n/2个
* 思路2：遍历，统计
* 思路3：摩尔投票法(必须满足有众数，且大于一半)，假设第一个数为众数，比较下一个与其是否相等，相等票数加一，不相等减一，票数为0则更换候选人
* @author 倪路
*/
public class LeetCode_Majorit_yElement {
    public int majorityElement1 (int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    public int majorityElement2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            if(countMap.containsKey(num)) {
                int temp = countMap.get(num) + 1;
                if(temp > nums.length / 2) {
                    return num;
                }
                countMap.put(num, temp);
            } else {
                countMap.put(num, 1);
            }
        }
        
        return -1;
    }
    
    public int majorityElement3(int[] nums) {
        int res = nums[0], count = 0;
        for(int num : nums) {
            if(count == 0) {
                res = num;
                count++;
            } else if(num == res) {
                count++;
            } else {
                count--;
            }
        }
        
        return res;
    }
}
