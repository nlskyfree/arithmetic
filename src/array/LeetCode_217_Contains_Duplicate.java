package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
* 题目：Contains Duplicate
* Given an array of integers, find if the array contains any duplicates.
* 
* Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
* 
* Example 1:
* 
* Input: [1,2,3,1]
* Output: true
* Example 2:
* 
* Input: [1,2,3,4]
* Output: false
* Example 3:
* 
* Input: [1,1,1,3,3,4,3,2,4,2]
* Output: true
* 思路1：双重循环 O(n^2)
* 思路2：排序+判等 O(nlogn)
* 思路3：Hashset O(n) O(n)
* @author 倪路
*/
public class LeetCode_217_Contains_Duplicate {
    public boolean containsDuplicate1(int[] nums) {
        if(nums == null) {
            return false;
        }
        
        int len = nums.length;
        for(int i = 0 ; i < len ; i++) {
            for(int j = i + 1 ; j < len ; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean containsDuplicate2(int[] nums) {
        if(nums == null) {
            return false;
        }
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i - 1] == nums[i]) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean containsDuplicate3(int[] nums) {
        if(nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }
}
