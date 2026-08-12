class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: Run DFS from all border 'O' cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBorder = (i == 0 || i == m - 1 || j == 0 || j == n - 1);
                if (isBorder && board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }

        // Step 2: Final pass - convert remaining 'O' to 'X', and 'S' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'S'; // mark as safe

        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}