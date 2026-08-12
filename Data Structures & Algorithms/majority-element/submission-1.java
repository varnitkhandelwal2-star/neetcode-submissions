class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int maxfreq = 0 ;
        int res = 0 ;
        for(int num:nums){
            map.put(num,map.getOrDefault(num, 0) + 1); 
            if (map.get(num)>maxfreq) {
                maxfreq = map.get(num) ;
                res = num ;
            }
        }
        return res ; 
    }
}