class Solution {
    public int [] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjency = new ArrayList<>() ;
        List<Integer> result = new ArrayList<>() ;
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
       // DFS loop first
for (int i = 0; i < size; i++) {
    if (dfs(i, adjency, result, state) == false) {
        return new int[]{};
    }
}

// THEN create arr after result is fully filled
int[] arr = new int[result.size()];
for(int i = 0; i < result.size(); i++){
    arr[i] = result.get(i);
}

return arr;
    }
    boolean dfs(int course ,List<List<Integer>> adjency ,List<Integer> result,int[] state    ){
        if(state[course]==2) return true ;
        if(state[course]==1) return false ;

        state[course] = 1 ;

        for(int preq:adjency.get(course)){
            if(dfs(preq,adjency , result,state)==false) return false ;
        }
        state[course] =2 ;
        result.add(course) ;
        return true ;
    }
}
