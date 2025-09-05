/** 345. Reverse Vowels of a String - https://leetcode.com/problems/reverse-vowels-of-a-string
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters. **/

// Brutforce Approach
class Solution {
    public String reverseVowels(String s) {
        StringBuilder sbVowels = new StringBuilder();
        StringBuilder sbReversed = new StringBuilder();
        int len = s.length();
        Set<Character> mp = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i=0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(mp.contains(ch))
            {
                sbVowels.append(ch);
            }
        }
        int vowelsLength = sbVowels.length();
        int j=0;
        for(int i=0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(!mp.contains(ch))
            {
                sbReversed.append(ch);
            }
            else
            {
                sbReversed.append(sbVowels.charAt(vowelsLength - j - 1));
                j++;
            }
        }
        return sbReversed.toString();
    }
}

// Optimal Sollution
class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i=0, j = s.length() - 1;
        while(i < j)
        {
            while(i<j && !isVowel(str[i])) i++; 
            while(i<j && !isVowel(str[j])) j--;
            if(i<j) 
            {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        return new String(str);
    }

    private boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}