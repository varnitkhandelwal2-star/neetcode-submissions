class Solution {
    
    private boolean isSafe(char[][] board, int row, int col, int n) {

        // ⬆️ Up in same column
        for (int r = row - 1; r >= 0; r--)
            if (board[r][col] == 'Q') return false;

        // ↖️ Upper-left diagonal
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--)
            if (board[r][c] == 'Q') return false;

        // ↗️ Upper-right diagonal
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++)
            if (board[r][c] == 'Q') return false;

        return true;
    }

    public int solve (char[][] board, int row, int n) {
        int count =0 ;
        if (row == n) {
            count++ ;
            return 1 ;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                count+= solve(board, row + 1, n);
                board[row][col] = '.';
            }
        }
        return count ;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) java.util.Arrays.fill(row, '.');
        return solve(board, 0, n);
        
    }

}