/** 2352. Equal Row and Column Pairs - https://leetcode.com/problems/equal-row-and-column-pairs
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105 **/

// Brutforce Approach
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean equal = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) count++;
            }
        }

        return count;
    }
}

// Better Approach
class Solution {
    public int equalPairs(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<List<Integer>> rows = new ArrayList<>();
        for(int[] r: grid)
        {
            rows.add(Arrays.stream(r).boxed().toList());
        }
        int count = 0;
        for(int i=0;i<row;i++)
        {
            List<Integer> colArray = new ArrayList<>();
            for(int j=0;j<col;j++)
            {
                colArray.add(grid[j][i]);
            }
            for(List<Integer> r: rows)
            {
                if(r.equals(colArray)) count++;
            }
        }
        return count;
    }
}

// Optimal Approach
class Solution {
    public int equalPairs(int[][] grid) {
        int len = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for(int[] row: grid)
        {
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        int count = 0;
        for(int i=0;i<len;i++)
        {
            int[] col = new int[len];
            for(int j=0;j<len;j++)
            {
                col[j] = grid[j][i];
            }
            String key = Arrays.toString(col);
            count += map.getOrDefault(key, 0);
        }
        return count;
    }
}