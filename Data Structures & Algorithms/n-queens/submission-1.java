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

    private void solve(char[][] board, int row, int n, List<List<String>> results) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board)
                solution.add(new String(r));
            results.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, row + 1, n, results);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) java.util.Arrays.fill(row, '.');
        List<List<String>> results = new ArrayList<>();
        solve(board, 0, n, results);
        return results;
    }
}