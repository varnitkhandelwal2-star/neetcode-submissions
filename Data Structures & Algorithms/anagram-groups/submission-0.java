class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List <String>> map = new HashMap<>() ;
        for (String word : strs ){
          char[] variable = word.toCharArray();
           Arrays.sort(variable);
           String key = new String (variable);
            List<String> group = map.getOrDefault(key ,new ArrayList<>()) ;
            group.add(word)    ;    // word add karo group mein
            map.put(key, group) ;   // map update karo
        }
        return new ArrayList<>(map.values()) ;
    }
}
