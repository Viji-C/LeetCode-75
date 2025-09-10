/** 1679. Max Number of K-Sum Pairs - https://leetcode.com/problems/max-number-of-k-sum-pairs/

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109 **/

// Brutforce Approach
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        boolean[] used = new boolean[len];
        for(int i=0;i<len;i++)
        {
            if(used[i]) continue; 
            for(int j=i+1;j<len;j++)
            {
                if(!used[j] && nums[i] + nums[j] == k)
                {
                    count++;
                    used[j] = true;
                    used[i] = true;
                    break;
                }
            }
        }
        return count;
    }
}

//Better Approach
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++)
        {
            int rem = k-nums[i];
            if(map.getOrDefault(rem, 0) > 0)
            {
                count++;
                map.put(rem, map.get(rem)-1);
            }
            else
            {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
        }
        return count;
    }
}

// Optimal Approach
class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        Arrays.sort(nums);
        int i=0,j=len-1;
        while(i < j)
        {
            int sum = nums[i] + nums[j];
            if(sum == k)
            {
                i++;
                j--;
                count++;
            }
            else if(sum > k) j--;
            else i++;
        }
        return count;
    }
}