
/*
有问题的地方： helper()pass的参数
需要解决了一个list提前结束的问题 + 进位的问题

*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return
        }
        ListNode result = new ListNode(0);
        
        result.next = helper(l1.next, l2.next. carry);
    }
    
    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null || l2 == null) {
            return l1;
        }
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }  
    }
}

// We assume the two input linkedlist are not empty

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;

        // Add the two nodes seperately
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}