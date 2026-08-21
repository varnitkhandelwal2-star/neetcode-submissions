class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people) ;
        int right = people.length -1 ;
        int left = 0 ;
        int count = 0 ;
        while (right>=left){
            int sum = people[right]+people[left] ;
            count++ ;
            if(sum <= limit){
                right-- ;
                left++ ;
            }
            if(sum>limit){
                right-- ;
            }
        }
        return count ; 
    }
}