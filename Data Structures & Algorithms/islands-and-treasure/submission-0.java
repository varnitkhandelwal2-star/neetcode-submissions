class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        // STEP 1 - Add all treasure chests to queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        // STEP 2 - BFS from all treasures simultaneously
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Skip if out of bounds, water, or already visited
                if(newRow < 0 || newRow >= grid.length || 
                   newCol < 0 || newCol >= grid[0].length || 
                   grid[newRow][newCol] != 2147483647) continue;
                
                // Update distance
                grid[newRow][newCol] = grid[row][col] + 1;
                
                // Add to queue
                queue.add(new int[]{newRow, newCol});
            }
        }
    }
}