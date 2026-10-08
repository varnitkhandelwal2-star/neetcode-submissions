class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int maxweight = 0;
        int sum = 0 ;
        for(int i=0 ; i<weights.length ; i++){
             sum+=weights[i] ;
        if(weights[i] > maxweight) maxweight = weights[i];
        }
        int right = sum ;
        int left = maxweight ;
        int mid = 0 ;
        while(right>=left){
            mid = left + (right-left)/2 ;
            if(countdays(weights , mid) <= days) right = mid-1 ;
            else left = mid+1 ;
        }
        return left ;
        
    }
    int countdays(int[] weights, int capacity)  {
            int currentload = 0 ;
            int days = 1 ;
            for(int i=0 ; i<weights.length ; i++ ){
                if(currentload+weights[i] > capacity ){
                    days++ ;
                    currentload = 0 ;
                }
                currentload += weights[i] ;
            }
            return days ;
        }
}
