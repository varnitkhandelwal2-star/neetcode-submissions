class Solution {
    public int maxProfit(int[] prices) {
        int holding = -prices[0] ;
        int free = 0 ;
        int cool = 0 ;

        for(int i=0 ; i<prices.length ; i++) {
         int prevHolding = holding;
            int prevFree = free;
            int prevCool = cool;

        
            holding = Math.max(prevHolding, prevFree - prices[i]);
            free    = Math.max(prevFree, prevCool);
            cool    = prevHolding + prices[i];
        }

        return Math.max(free,cool) ;
    }
}
