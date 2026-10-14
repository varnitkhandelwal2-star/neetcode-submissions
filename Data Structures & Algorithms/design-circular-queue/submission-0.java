class MyCircularQueue {
    int[] queue;
    int front;
    int size;
    int k;
    public MyCircularQueue(int k) {
        this.k = k;
        queue = new int[k];
        this.front = 0;  // shuru mein 0
        this.size = 0;   // shuru mein empty
    }
    
    public boolean enQueue(int value) {
        if(size==k) return false ;
        queue[(front + size) % k] = value;
        size++ ;
        return true ;
    }
    
    public boolean deQueue() {
        if(size==0) return false ;
        front = (front+1) %k ;
        size-- ;
        return true ;
    }
    
    public int Front() {
        if(size==0) return -1 ;
        else return queue[front] ; 
    }
    
    public int Rear() {
        if(size==0) return -1 ;
        else return queue[(front + size - 1) % k ] ;
    }
    
    public boolean isEmpty() {
        if(size==0) return true ;
        else return false ;
    }
    
    public boolean isFull() {
        if(size==k) return true ;
        else return false ;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */