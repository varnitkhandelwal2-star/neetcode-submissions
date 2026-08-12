class Solution {
     List<List<Integer>> graph = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
for (int i = 0; i <=edges.length; i++) {
    graph.add(new ArrayList<>());
}
for(int[] edge : edges){
    int a = edge[0];
    int b = edge[1];
    boolean[] visited = new boolean[edges.length + 1];
    if(dfs(a,b , visited )){
        return new int[]{a,b};
    }else{
          graph.get(a).add(b);
           graph.get(b).add(a);
    }
}
return new int[]{} ;
 }
    boolean dfs(int src , int target , boolean[] visited ){
        if(src==target) return true ;
        visited[src] = true ;
        for(int neighbor:graph.get(src)){
            if(!visited[neighbor]){
               if( dfs(neighbor,target,visited) ){
                return true ;
               }
            }
        }
        return false ;
    }
}
