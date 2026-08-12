class Solution {
    public int maxArea(int[] heights) {
        int left = 0 ;
        int n = heights.length ;
        int right=n-1 ;
        int max = 0 ;
        while (left < right ){
        int area = Math.min(heights[left], heights[right]) * (right-left) ;
        max = Math.max(max, area);
            if (heights[left] <heights[right]){
                left++ ;
            }
            else if (heights[left] > heights[right]){
                right-- ;
            }
            else if (heights[left] == heights[right]){
                left ++ ;
            }
          }
                return max ;
        }
    }

