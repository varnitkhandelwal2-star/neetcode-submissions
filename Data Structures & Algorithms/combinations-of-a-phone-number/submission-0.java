class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map <Character , String >map = new HashMap<>() ;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    if(digits.isEmpty()) return result;
      solve(0,"",digits,result,map) ;
      return result ;
    }
    void solve(int index , String current , String digits , List<String>result, Map<Character,String> map){
          if (index==digits.length()){
            result.add(current) ;
            return ;
        }
        String letters = map.get(digits.charAt(index)) ;
        for(int i = 0 ; i<letters.length() ; i++){
            char ch = letters.charAt(i) ;
            solve(index+1 , current+ ch, digits , result,map) ;
        }
    }
}
