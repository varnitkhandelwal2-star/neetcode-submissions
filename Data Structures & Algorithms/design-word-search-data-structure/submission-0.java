class TrieNode{
    TrieNode[] children = new TrieNode[26] ;
    boolean isEnd = false ;
}
class WordDictionary {
    TrieNode root ;
    public WordDictionary() {
        root= new TrieNode() ;
    }

    public void addWord(String word) {
        TrieNode current = root ;
        for(char ch:word.toCharArray()){
            int idx = ch-'a' ;
            if (current.children[idx]==null){
            current.children[idx] = new TrieNode();
            }
             current = current.children[idx] ;
        }
         current.isEnd = true ;
    }

     public boolean search(String word) {
        return dfs(0, root, word);
    }

    boolean dfs(int index, TrieNode node, String word) {
        if(index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        if(ch != '.') {
            int idx = ch - 'a';
            if(node.children[idx] == null) {
                return false;
            }
            return dfs(index + 1, node.children[idx], word);
        }

        // wildcard '.'
        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) {
                if(dfs(index + 1, node.children[i], word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
