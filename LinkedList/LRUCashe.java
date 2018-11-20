class LRUCache {
	HashMap<Integer, DoubleLinkNode> cache;
    int capacity;
    int count;
    DoubleLinkNode head , tail;

    class DoubleLinkNode{
        int key, value;
        DoubleLinkNode pre, next;
        public DoubleLinkNode (int key, int value){
            this.key = key;
            this.value = value;
        }
        DoubleLinkNode(){
            this.key = 0;
            this.value = 0;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        cache = new HashMap<>();
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if(node == null)
            return -1;
        else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            //add it
            DoubleLinkNode node = new DoubleLinkNode(key, value);
            cache.put(key,node);
            addNode(node);
            count++;
            if(count>capacity) {
            DoubleLinkNode tail = removeTail();
            cache.remove(tail.key);
            count--;
            }
        }
        else {
            //move it to head
            DoubleLinkNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(DoubleLinkNode node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DoubleLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DoubleLinkNode removeTail() {
        DoubleLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }
}
