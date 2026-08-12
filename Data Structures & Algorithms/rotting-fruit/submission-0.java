class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        // STEP 1 - count fresh, add rotten to queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        // STEP 2 - BFS level by level
        int[][] dirc = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for(int[] dir : dirc){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow < 0 || newRow >= grid.length ||
                       newCol < 0 || newCol >= grid[0].length ||
                       grid[newRow][newCol] != 1) continue;

                    grid[newRow][newCol] = 2;
                    fresh--;
                    queue.add(new int[]{newRow, newCol});
                }
            }
            minutes++;
        }

        // STEP 3 - return
        return fresh == 0 ? minutes : -1;
    }
}