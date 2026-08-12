class Solution {
     boolean[] visited ;
     List<List<Integer>> adjency = new ArrayList<>() ;
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n] ;
        int count = 0 ;

        for(int i=0 ; i<n ;i++){
            adjency.add(new ArrayList<>()) ;
        }
        for(int[] edge:edges){
            int a = edge[0] ;
            int b = edge[1] ;
            adjency.get(a).add(b) ;
            adjency.get(b).add(a) ;
        }
        for (int i=0 ; i<n ; i++){
            if (!visited[i]){
                count ++ ;
                dfs(i);
            }
        }
        return count ;
    }
     void dfs(int i ){
        visited[i] = true ;
        for(int neighbor:adjency.get(i)){
            if (!visited[neighbor]){
                dfs(neighbor) ;
            }
        }
    }
}
