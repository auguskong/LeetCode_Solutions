/**
* Date: 01/11/2019
* Type: Implementation
* 
*/

class LRUCache {
    class DoubleLinkedNode {
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        // Save both key and value in the Double Linked ListNode
        int key;
        int val;
        DoubleLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    // Define the global variable head and tail 
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    HashMap<Integer, DoubleLinkedNode> cache;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        cache = new HashMap();
        
        head = new DoubleLinkedNode(0, 0);
        tail = new DoubleLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    private void addToHead(DoubleLinkedNode node) {
        DoubleLinkedNode next = head.next;
        head.next = node;
        node.prev = head;
        
        node.next = next;
        next.prev = node;
    }
    
    private void remove(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        // point to null node, free the space
        node.next = null;
        node.prev = null;
    }
    
    private void moveToHead(DoubleLinkedNode node) {
        remove(node);
        addToHead(node);
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DoubleLinkedNode cur = cache.get(key);
        moveToHead(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (count == capacity) {
                DoubleLinkedNode tailNode = tail.prev;
                remove(tailNode);
                cache.remove(tailNode.key);
            } else {
                count++;
            }
            DoubleLinkedNode curNode = new DoubleLinkedNode(key, value);
            cache.put(key, curNode);
            addToHead(curNode);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */