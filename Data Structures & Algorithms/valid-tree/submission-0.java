class Solution {
    public boolean validTree(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjency = new ArrayList<>() ;
        int size = numCourses ;
        int[] state = new int[size];
        
        for (int i = 0; i < size; i++) {
    adjency.add(new ArrayList<>());
}
        for (int[] preq : prerequisites) {
            int a = preq[0];
            int b = preq[1];
            adjency.get(b).add(a) ;
             adjency.get(a).add(b) ;
    }
       
            if(dfs(0,-1,adjency, state)==false ){
                return false ;
    
        }
        for (int i = 0; i < size; i++) {
            if (state[i] == 0) return false;  
        }
        return true ; 
    }
    boolean dfs(int course ,int parent , List<List<Integer>> adjency ,int[] state ){
        if(state[course]==2) return true ;
        if(state[course]==1) return false ;
      
        state[course] = 1 ;

          for(int preq : adjency.get(course)){
        if(preq == parent) continue;  // ← skip parent, not a cycle
        if(dfs(preq, course, adjency, state) == false) return false;
    }
        state[course] =2 ;
        return true ;
    }
}
