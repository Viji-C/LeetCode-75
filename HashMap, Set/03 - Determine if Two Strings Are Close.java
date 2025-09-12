/** 1657. Determine if Two Strings Are Close - https://leetcode.com/problems/determine-if-two-strings-are-close

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters. **/

// Solution
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 != len2) return false;
        if(word1.equals(word2)) return true;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<len1;i++)
        {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            map1.put(char1, map1.getOrDefault(char1, 0)+1);
            map2.put(char2, map2.getOrDefault(char2, 0)+1);
        }
        for(char c : map1.keySet())
        {
            if(!map2.containsKey(c)) return false;
        }
        List values1 = new ArrayList(map1.values());
        List values2 = new ArrayList(map2.values());
        Collections.sort(values1);
        Collections.sort(values2);
        for(int i=0;i<values1.size();i++)
        {
            if(!values1.get(i).equals(values2.get(i))) return false;
        }
        return true;
    }
}

// Optimal Solution
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 != len2) return false;
        if(word1.equals(word2)) return true;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char c : word1.toCharArray())
        {
            freq1[c - 'a']++;
        }
        for(char c : word2.toCharArray())
        {
            freq2[c - 'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if((freq1[i] == 0 && freq2[i] !=0) || (freq1[i]!=0 && freq2[i] == 0)) return false;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}