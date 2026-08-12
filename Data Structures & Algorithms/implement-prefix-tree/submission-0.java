class TrieNode {                              
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class PrefixTree {
    TrieNode root;                            
    public PrefixTree() {
        root = new TrieNode();    
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            int idx = ch -'a' ;
            if(current.children[idx]==null){
                current.children[idx] = new TrieNode() ;
            } 
            current=current.children[idx] ;
        }
        current.isEnd = true ;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            int  idx = ch-'a' ;
            if(current.children[idx]==null){
                return false ;
            }
              current=current.children[idx] ;
        }
        return current.isEnd ;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
          for(char ch: prefix.toCharArray()){
            int  idx = ch-'a' ;
            if(current.children[idx]==null){
                return false ;
            }
             current= current.children[idx] ;
        }
        return true ;
    }
}
