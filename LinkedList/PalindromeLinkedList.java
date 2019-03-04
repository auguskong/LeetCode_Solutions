/**
Data: 05/14/18
Author: 

This code is for LeetCode 234. PalindromeLinkedlist
Key: reverse the linkedlist, and then compare the first half of the 
*/

class Solution {
	boolean isPalindrome(ListNode head) {
		ListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	ListNode reverseAndClone(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode curr = new ListNode(head.val) // Clone
			curr.next = prev;
			prev = curr;    
			head = head.next;
		}
		return prev;
	}
	
	boolean isEqual(ListNode one, ListNode two) {
		whilie (one != null && two != null) {
			if (one.val != two.val) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two = null;
	}
}

class Solution {
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // odd nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = reverse(slow);
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

	public ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
}
