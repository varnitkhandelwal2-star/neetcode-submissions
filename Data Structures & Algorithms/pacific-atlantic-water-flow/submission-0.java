class Solution {
    int[][] dirc = {{0,1},{1,0},{0,-1},{-1,0}} ;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row = heights.length ; 
        int col = heights[0].length ;
        List<List<Integer>> res = new ArrayList<>() ;
        boolean[][] pac = new boolean[row][col] ;
        boolean[][] atlan = new boolean[row][col] ;

     for(int i = 0; i < row; i++){
    dfs(i, 0, pac, heights, 0);         
    dfs(i, col-1, atlan, heights, 0);    
}


for(int i = 0; i < col; i++){
    dfs(0, i, pac, heights, 0);           
    dfs(row-1, i, atlan, heights, 0); 
}
        for(int i=0 ; i<heights.length ; i++){
           for(int j=0 ; j<heights[0].length ; j++){
            if(atlan[i][j] && pac[i][j]){
            res.add(Arrays.asList(i,j)) ;
            }
           }
        }
        return res ;
    }
    public void dfs(int i , int j , boolean[][] visited , int[][] heights, int prev){
       if(i<0 || i>=heights.length || j<0 || j>=heights[0].length) return;
        if(visited[i][j]) return;
        if(heights[i][j] < prev) return;
        visited[i][j] = true;
        for(int[] dir : dirc){
        dfs(i+dir[0], j+dir[1], visited, heights, heights[i][j]);
}

    }
}
