class Solution {
    List<Integer> current = new ArrayList<>() ;
    List<List<Integer>> result = new ArrayList<>() ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums) ;
    boolean[] used = new boolean[nums.length] ;
        backtrack(nums , used );
        return result ;
    }
    void backtrack (int[] nums , boolean[]used ){
        if(current.size()==nums.length) result.add(new ArrayList(current)) ;
        for (int i=0 ; i<nums.length ; i++){
            if(used[i]) continue ;
                if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue ;
                    used[i] = true ;
                    current.add(nums[i]) ;
                    backtrack(nums , used) ;
                    used[i] = false;
                    current.remove(current.size()-1);
        }
    }
}