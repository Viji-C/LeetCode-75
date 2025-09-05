605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length

// First Approach:
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int al = flowerbed.length;
        int count = 0, i=1;
        if(al == 1)
        {
            if(flowerbed[0] == 0 ) 
            {
                count++;
            }
        }
        else 
        {
            if(flowerbed[0] == 0 && flowerbed[1] == 0) 
            {
                count++;
                flowerbed[0] = 1;
            }
        }

        while(i<al-1)
        {
            if(flowerbed[i] == 0 && flowerbed[i-1] != 1 && flowerbed[i+1] != 1)
            {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        if(al>=2 && flowerbed[al-1] == 0 && flowerbed[al-2] == 0) count++;
        return count >= n;

    }
}

// Optimal Approach
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        for(int i = 0; i < len; i++)
        {
            if(flowerbed[i] == 0)
            {
                int prev = (i == 0) ? 0 : flowerbed[i-1];
                int next = (i == len-1) ? 0 : flowerbed[i+1];
                if(prev == 0 && next == 0)
                {
                    flowerbed[i] = 1;
                    count++;
                    if(count >= n) return true;
                }
            }
        }
        return count >= n;
    }
}