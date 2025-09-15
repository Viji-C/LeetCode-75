/** 328. Odd Even Linked List - https://leetcode.com/problems/odd-even-linked-lis

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106 **/

// Brutforce Approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        List<ListNode> oddList = new ArrayList<>();
        List<ListNode> evenList = new ArrayList<>();
        int index = 1;
        while(temp!=null)
        {
            if(index%2!=0)
            {
                oddList.add(temp);
            }
            else 
            {
                evenList.add(temp);
            }
            temp = temp.next; 
            index++;
        }
        ListNode newhead = new ListNode(0);
        ListNode reorderedList=newhead;
        for(int i=0;i<oddList.size();i++)
        {
            reorderedList.next = oddList.get(i);
            reorderedList = reorderedList.next;
        }
        for(int i=0;i<evenList.size();i++)
        {
            reorderedList.next = evenList.get(i);
            reorderedList = reorderedList.next;
        }
        reorderedList.next = null;
        return newhead.next;
    }
}

// Better Approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy, even = evenDummy;
        int index = 1;
        ListNode curr = head;
        while(curr!=null)
        {
            if(index%2!=0)
            {
                odd.next=curr;
                odd = odd.next;
            }
            else 
            {
                even.next=curr;
                even = even.next;
            }
            curr = curr.next; 
            index++;
        }
        even.next = null;
        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}

// Optimal Approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        int index = 1;
        ListNode curr = head;
        while(even != null && even.next!=null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}