class Node {
    int key, value, freq;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    Node head, tail;
    int size;

    DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    Node removeLast() {
        if (size == 0) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }
}

class LFUCache {
    HashMap<Integer, Node> keyMap;          // key -> node
    HashMap<Integer, DoublyLinkedList> freqMap;  // freq -> DLL
    int capacity, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).size == 0) {
            freqMap.remove(freq);
            if (minFreq == freq) minFreq++;
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addFront(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyMap.size() == capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node removed = minList.removeLast();
                keyMap.remove(removed.key);
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            freqMap.putIfAbsent(1, new DoublyLinkedList());
            freqMap.get(1).addFront(newNode);
            minFreq = 1;
        }
    }
}