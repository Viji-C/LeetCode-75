/** 283. Move Zeroes - https://leetcode.com/problems/move-zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done? **/

// First Approach
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        int len = nums.length;
        while(i<len && j<len)
        {
            if(nums[i] == 0 && nums[j] != 0)
            {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }
            else if(nums[i] == 0 && nums[j] == 0)
            {
                j++;
            }
            else
            {
                i++;
                j++;
            }
        }
    }
}

// Better Approach
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int nonNegative = 0;
        for(int i=0;i<len;i++)
        {
            if(nums[i] != 0)
            {
                nums[nonNegative] = nums[i];
                nonNegative++;
            }
        }
        for(int i=nonNegative;i<len;i++)
        {
            nums[i] = 0;
        }
    }
}