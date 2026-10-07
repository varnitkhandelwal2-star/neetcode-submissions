class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        
        long left = 1, right = x;
        long mid = 0;
        
        while(right >= left){
            mid = left + ((right-left)/2);
            
            if(mid*mid == x) return (int)mid;
            else if(mid*mid > x) right = mid-1;
            else left = mid+1;
        }
        
        return (int)right;
    }
}