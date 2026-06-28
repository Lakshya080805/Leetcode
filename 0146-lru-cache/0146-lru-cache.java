class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer,Node> map; // Node for directly accessing node from linked list
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;

        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }

    void insert(Node node){
        node.next=head.next;
        node.prev=head;

        head.next.prev=node;
        head.next=node;     
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;

        Node node=map.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;

            remove(node);
            insert(node);
        }
        else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */