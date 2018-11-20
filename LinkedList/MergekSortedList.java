class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
               pq.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            head.next = curr;
            if (curr.next != null) {
                pq.add(curr.next);
            }
            head = head.next;
        }
        return dummy.next;
    }
}