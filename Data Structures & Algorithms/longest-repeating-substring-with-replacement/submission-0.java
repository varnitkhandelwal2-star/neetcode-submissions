class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> count = new HashMap<>();
        int maxln = 0;
        int maxfreq = 0;
        int left = 0;
        for(int right=0 ; right<s.length() ;right++ ){
            char c = s.charAt(right);
            count.put(c,count.getOrDefault(c,0)+1);
            maxfreq = Math.max(maxfreq , count.get(c)); 
            if((right-left+1)-maxfreq>k){
                count.put(s.charAt(left),count.get(s.charAt(left)) - 1);
                left++;
            }
            maxln = Math.max(maxln,right-left+1);
        }
        return maxln ;
    }
}
