class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int result[] = new int[n] ;
        for  (int i=0 ; i<n ; i++){
            while ( !stack.isEmpty() && temperatures[i] >temperatures[stack.peek()]){
                int popped = stack.pop() ;
                result[popped] = i- popped ;
            }
            stack.push(i) ;
        }   
        return result ;
    }
}
