class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0 ; i<board.length ;i++){
             for (int j=0 ; j<board[0].length ;j++){
            if(board[i][j]==word.charAt(0)){
                if (dfs(board,word,i,j,0)){
                return true ;
               }
             }
           }  
        }
        return false ;
    }
    boolean dfs(char[][] board,String word,int row,int col, int index){
        if(index==word.length()){
            return true ;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
          return false ;
        }
         if (board[row][col] != word.charAt(index)){
            return false ;
        }
        else if (board[row][col] == '#'){
            return false ;
        }
        char temp = board[row][col];
            board[row][col] = '#';
        boolean result = dfs(board, word, row + 1, col, index + 1) || // down
                     dfs(board, word, row - 1, col, index + 1) || // up
                     dfs(board, word, row, col + 1, index + 1) || // right
                     dfs(board, word, row, col - 1, index + 1);   // left
        
        board[row][col] = temp;
        
        return result ;
    }
}
