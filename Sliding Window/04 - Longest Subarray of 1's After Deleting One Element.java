/** 1493. Longest Subarray of 1's After Deleting One Element - https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.  **/

//Solution
class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int cz = 0,j=0,ans=0;
        for(int i=0;i<len;i++)
        {
            if(nums[i] == 0) cz++;
            while(cz>1)
            {
                if(nums[j] == 0) cz--;
                j++;
            }
            ans = Math.max(ans, (i-j));
        }
        return ans;
    }
}