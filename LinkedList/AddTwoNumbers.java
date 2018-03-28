
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
