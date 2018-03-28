
// 指针调用灵活 保留头结点 + 尾节点
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode n1 = head;
        ListNode n2 = head.next;
        
        while(n1 != null && n2 != null && n2.next != null) {
            prev.next = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            prev = n1;
        }
        
        return dummy.next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
    
        while(prev.next != null && prev.next.next != null) {
            ListNode n1 = prev.next;
            ListNode n2 = prev.next.next;
            prev.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            prev = n1;
        }
        
        return dummy.next;
    }
}