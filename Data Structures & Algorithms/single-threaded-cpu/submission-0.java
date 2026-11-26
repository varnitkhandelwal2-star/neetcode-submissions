class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        // keep original index
        int[][] indexedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            indexedTasks[i][0] = tasks[i][0]; // enqueueTime
            indexedTasks[i][1] = tasks[i][1]; // processingTime
            indexedTasks[i][2] = i;            // original index
        }
        
        // sort by enqueueTime
        Arrays.sort(indexedTasks, (a, b) -> a[0] - b[0]);
        
        // minHeap: [processingTime, originalIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        
        int[] result = new int[n];
        long time = 0;
        int i = 0, idx = 0;
        
        while (idx < n) {
            // add all available tasks to pq
            while (i < n && indexedTasks[i][0] <= time) {
                pq.offer(new int[]{indexedTasks[i][1], indexedTasks[i][2]});
                i++;
            }
            
            if (pq.isEmpty()) {
                // cpu idle, jump to next task time
                time = indexedTasks[i][0];
                continue;
            }
            
            int[] curr = pq.poll();
            time += curr[0];
            result[idx++] = curr[1];
        }
        
        return result;
    }
}