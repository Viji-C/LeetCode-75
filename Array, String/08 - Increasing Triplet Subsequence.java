/** 334. Increasing Triplet Subsequence - https://leetcode.com/problems/increasing-triplet-subsequence/

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (3, 4, 5), because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1 **/

// Brutforce Approach

// Three for loops iterate (0 - n-1) and (i+1 - n-2) and (i+2 - n-3)
// Check if nums[i] < nums[j] < nums[k] return true
// at end return false if there is no triplets

// Optimal Sollution
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i=0;i<len;i++)
        {
            if(nums[i] <= first) first = nums[i];
            else if (nums[i] <= second) second = nums[i];
            else return true;
        }
        return false;
    }
}