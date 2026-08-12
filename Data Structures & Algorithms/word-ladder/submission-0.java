class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Object[]> queue = new LinkedList<>() ;
        queue.offer(new Object[] {beginWord,1});
        Set<String> visited = new HashSet<>() ;
        visited.add(beginWord) ;

        while(!queue.isEmpty()){
         Object[] curr = queue.poll();
        String currentWord = (String) curr[0];
            int steps = (int) curr[1];
            for(String word:wordList){
                if(!visited.contains(word) && isNeighbor(currentWord, word)){
                    if(word.equals(endWord)){
                        return steps+1 ;
                    }
                queue.offer(new Object[]{word,steps+1}) ;
                visited.add(word);
                }
            }
        }
        return 0 ;

    }
    boolean isNeighbor (String word1 , String word2){
        int diff=0 ;
        for(int i= 0 ; i<word1.length() ; i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                diff++ ;
            }
        }
        return diff==1 ;
    }
}
