class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    String word = null;
}

class Solution {
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // insert all words into trie
        for(String word : words){
            TrieNode current = root;
            for(char ch : word.toCharArray()){
                int idx = ch - 'a';
                if(current.children[idx] == null){
                    current.children[idx] = new TrieNode();
                }
                current = current.children[idx];
            }
            current.isEnd = true;
            current.word = word;
        }

        // start dfs from every cell
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    void dfs(char[][] board, int i, int j, 
             TrieNode node, List<String> result){

        // out of bounds
        if(i < 0 || i >= board.length) return;
        if(j < 0 || j >= board[0].length) return;

        // already visited
        if(board[i][j] == '#') return;

        // not in trie
        int idx = board[i][j] - 'a';
        if(node.children[idx] == null) return;

        // move to next node
        TrieNode next = node.children[idx];
        char temp = board[i][j];

        // found a word!
        if(next.isEnd){
            result.add(next.word);
            next.isEnd = false; // avoid duplicates!
        }

        // mark visited
        board[i][j] = '#';

        // explore 4 directions
        dfs(board, i+1, j, next, result);
        dfs(board, i-1, j, next, result);
        dfs(board, i, j+1, next, result);
        dfs(board, i, j-1, next, result);

        // unmark
        board[i][j] = temp;
    }
}