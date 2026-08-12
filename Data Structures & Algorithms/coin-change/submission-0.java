class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0 ;
        int[] arr = new int[amount+1] ;
        arr[0] = 0 ;
        for(int i=1 ; i<=amount ; i++){
            arr[i] = Integer.MAX_VALUE ;
            for(int coin:coins){
                if(coin<=i && arr[i-coin]!=Integer.MAX_VALUE ){
                    arr[i] = Math.min(arr[i],1+arr[i-coin]) ;
                }
            }
        }
      
        return arr[amount] == Integer.MAX_VALUE ? -1 : arr[amount];
    }
}
