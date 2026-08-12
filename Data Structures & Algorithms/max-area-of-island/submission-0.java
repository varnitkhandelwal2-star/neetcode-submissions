class Solution {
    public int maxAreaOfIsland(int[][] grid){
        int area = 0 ;
        int maxArea =0 ;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
             if(grid[i][j]==1){
            area = bfs(i,j,grid) ;
            maxArea = Math.max(maxArea, area)  ;
                  }
       }
    } 
        return maxArea ;
    }
    int bfs(int i ,int j,int [][] grid ){
        if (i<0 || i>=grid.length ) return 0;
        if(j<0 || j>=grid[0].length )return 0;

        if (grid[i][j]==0) return 0;
        if (grid[i][j]==2) return 0;
       
        grid[i][j] = 2 ;

   return 1 +   bfs(i+1,j,grid) 
            +   bfs(i-1,j,grid) 
            +   bfs(i,j+1,grid) 
            +   bfs(i,j-1,grid) ;
    
    }
}
