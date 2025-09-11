/** 643. Maximum Average Subarray I - https://leetcode.com/problems/maximum-average-subarray-i/

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104 **/

//Brutforce Approach
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double ans = Integer.MIN_VALUE;
        for(int i=0;i<=len-k;i++)
        {
            double sum = 0;
            for(int j=i;j<i+k;j++)
            {
                sum+=nums[j];
            }
            ans = Math.max(ans, sum/k);
        }
        return ans;
    }
}

// PreSum Approach
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double ans = Integer.MIN_VALUE;
        int[] presum = new int[len+1];
        for(int i=0;i<len;i++)
        {
            presum[i + 1] = presum[i] + nums[i];
        }
        for(int i=k;i<=len;i++)
        {
            double asum = presum[i] - presum[i-k];
            ans = Math.max(ans, asum/k);
        }
        return ans;
    }
}

// Sliding Window
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<k;i++)
        {
            sum += nums[i];
        }
        int maxSum = sum;
        for(int i=k;i<len;i++)
        {
            sum += nums[i] - nums[i-k];
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum/k;
    }
}