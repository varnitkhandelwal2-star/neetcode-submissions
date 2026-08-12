class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int result = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                result = Math.max(result, dfs(matrix, memo, i, j));
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int[][] memo, int i, int j){
        if(memo[i][j] != 0) return memo[i][j];

        int best = 1;
        if(i > 0 && matrix[i-1][j] > matrix[i][j])
            best = Math.max(best, 1 + dfs(matrix, memo, i-1, j));
        if(i < matrix.length-1 && matrix[i+1][j] > matrix[i][j])
            best = Math.max(best, 1 + dfs(matrix, memo, i+1, j));
        if(j > 0 && matrix[i][j-1] > matrix[i][j])
            best = Math.max(best, 1 + dfs(matrix, memo, i, j-1));
        if(j < matrix[0].length-1 && matrix[i][j+1] > matrix[i][j])
            best = Math.max(best, 1 + dfs(matrix, memo, i, j+1));

        return  memo[i][j] = best;
    }
}