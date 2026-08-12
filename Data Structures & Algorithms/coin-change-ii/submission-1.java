class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return solve(0, amount, coins, memo);
    }

    public int solve(int i, int amount, int[] coins, int[][] memo){
        if(amount == 0) return 1;
        if(i == coins.length) return 0;
        if(memo[i][amount] != -1) return memo[i][amount];
        if(amount < coins[i]){
            return memo[i][amount] = solve(i + 1, amount, coins, memo);
        }
        int take = solve(i, amount - coins[i], coins, memo);
        int skip = solve(i + 1, amount, coins, memo);
        return memo[i][amount] = take + skip;
    }
}