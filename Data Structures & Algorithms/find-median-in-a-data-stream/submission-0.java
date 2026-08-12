class MedianFinder {
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a ) ;

    public MedianFinder() {
    
    }
    
    public void addNum(int num) {
     if(!maxHeap.isEmpty() && num <= maxHeap.peek()){
            maxHeap.offer(num) ;
     } else {
       minHeap.offer(num) ;
     }


     if (maxHeap.size() > minHeap.size() + 1 ){
        minHeap.offer(maxHeap.poll()) ;
     }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll()) ;
        }
    }
    
    public double findMedian() {
        double mean = 0.0 ;
        if(maxHeap.size() == minHeap.size()){
            mean = (maxHeap.peek() + minHeap.peek() )/ 2.0 ; 
        }else if (maxHeap.size() > minHeap.size()  ){
            mean = maxHeap.peek() ;
        }
        else {
            mean = minHeap.peek() ;
        }
        return mean ;
    }
}