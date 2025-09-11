/** 1004. Max Consecutive Ones III - https://leetcode.com/problems/max-consecutive-ones-iii

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length **/

// Brutforce Approach
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int maxones = 0;
        for(int i=0;i<len;i++)
        {
            int countZero = 0;
            for(int j=i;j<len;j++)
            {
                if(nums[j] == 0) countZero++;
                if(countZero>k) break;
                maxones = Math.max(maxones, j-i+1);
            }
        }
        return maxones;
    }
}

// Sliding Window
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0, len = nums.length, countZero=0,ans=0;
        while(i<len)
        {
            if(nums[i] == 0) countZero++;
            while(countZero>k)
            {
                if(nums[j] == 0) 
                {
                    countZero--;
                }
                j++;                
            }
            ans = Math.max(ans, (i-j+1));
            i++;
        }
        return ans;
    }
}