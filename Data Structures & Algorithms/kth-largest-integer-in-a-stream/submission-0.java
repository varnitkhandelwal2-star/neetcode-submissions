// class KthLargest {

//     public KthLargest(int k, int[] nums) {
//         PriorityQueue<Integer> minHeap;
//         minHeap = new PriorityQueue<>();
//             for (int num : nums) {
//              minHeap.add(val);
//     }
       
//     }
    
//     public int add(int val) {
//       if( minHeap.size()>k.size()){
//         minHeap.poll(minHeap.peek(););
//       }
//       return minHeap ;
//     }
// }
class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}