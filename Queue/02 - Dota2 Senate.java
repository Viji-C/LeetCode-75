/** 649. Dota2 Senate - https://leetcode.com/problems/dota2-senate/

In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

 

Example 1:

Input: senate = "RD"
Output: "Radiant"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
Example 2:

Input: senate = "RDD"
Output: "Dire"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 

Constraints:

n == senate.length
1 <= n <= 104
senate[i] is either 'R' or 'D'.  **/

// Brutforce Approach
class Solution {
    public String predictPartyVictory(String senate) {
        List<Character> list = new ArrayList<>();
        for(char c : senate.toCharArray())
        {
            list.add(c);
        }
        while(!list.isEmpty())
        {
            Boolean majority = true;
            char ch = list.remove(0);
            if(!list.isEmpty())
            {
                Boolean removed = false;
                for(int i=0;i<list.size();i++)
                {
                    if(ch != list.get(i)) 
                    {
                        majority = false;
                        list.remove(i);
                        removed = true;
                        break;
                    }
                }
                if(!removed) return list.get(0) == 'R' ? "Radiant" : "Dire";
                list.add(ch);
            } 
            else
            {
                return ch == 'R' ? "Radiant" : "Dire";
            }
            if(majority) break;
        }

        return list.get(0) == 'R' ? "Radiant" : "Dire";
    }
}

// Better Approach
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radient = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for(int i=0;i<n;i++)
        {
            if(senate.charAt(i) == 'R') radient.add(i);
            else dire.add(i);
        }
        while(!radient.isEmpty() && !dire.isEmpty())
        {
            int r = radient.poll();
            int d = dire.poll();
            if(r < d) radient.add(r+n);
            else dire.add(d+n);
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}

// Optimal Solution
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        int banD = 0, banR = 0;
        for(char c : senate.toCharArray())
        {
            q.add(c);
        }
        while(!q.isEmpty())
        {
            char c = q.poll();
            if(c == 'R')
            {
                if(banR > 0) 
                {
                    banR--;
                }
                else
                {
                    banD++;
                    q.add('R');
                }
            }
            else
            {
                if(banD > 0)
                {
                    banD--;
                }
                else
                {
                    banR++;
                    q.add('D');
                }
            }
            if(!q.contains('R')) return "Dire";
            if(!q.contains('D')) return "Radiant";
        }
        return "";
    }
}