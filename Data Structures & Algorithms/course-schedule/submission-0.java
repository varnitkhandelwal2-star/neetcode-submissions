class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjency = new ArrayList<>() ;
        int size = numCourses ;
        int[] state = new int[size];
        
        for (int i = 0; i < size; i++) {
    adjency.add(new ArrayList<>());
}
        for (int[] preq : prerequisites) {
            int a = preq[0];
            int b = preq[1];
            adjency.get(a).add(b) ;
    }
        for(int i=0 ; i<size ; i++){
            if(dfs(i,adjency, state)==false){
                return false ;
            }
        }
        return true ; 
    }
    boolean dfs(int course ,List<List<Integer>> adjency ,int[] state ){
        if(state[course]==2) return true ;
        if(state[course]==1) return false ;

        state[course] = 1 ;

        for(int preq:adjency.get(course)){
            if(dfs(preq,adjency , state)==false) return false ;
        }
        state[course] =2 ;
        return true ;
    }
}
