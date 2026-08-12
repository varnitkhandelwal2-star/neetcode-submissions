class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int[] point : points){
            int dis = point[0]*point[0] + point[1]*point[1];
            maxHeap.offer(new int[]{dis, point[0], point[1]});
            
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] top = maxHeap.poll();
            result[i] = new int[]{top[1], top[2]};
        }
        
        return result;
    }
}