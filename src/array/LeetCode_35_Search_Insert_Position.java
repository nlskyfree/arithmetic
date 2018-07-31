package array;

/**
* 题目：Search Insert Position
* Given a sorted array and a target value, return the index if the target is found. 
* If not, return the index where it would be if it were inserted in order.
* 
* You may assume no duplicates in the array.
* 
* Example 1:
* 
* Input: [1,3,5,6], 5
* Output: 2
* Example 2:
* 
* Input: [1,3,5,6], 2
* Output: 1
* Example 3:
* 
* Input: [1,3,5,6], 7
* Output: 4
* Example 4:
* 
* Input: [1,3,5,6], 0
* Output: 0
* 思路1：顺序查找，找到第一个大于等于target的位置即可，没找到，则为最后
* 思路2：二分查找
* @author 倪路
*/
public class LeetCode_35_Search_Insert_Position {
    public int searchInsert1(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        
        return nums.length;
    }
    
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
