class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>() ;
        for(int i=0 ; i<asteroids.length ; i++ ){
             boolean alive = true ;
            if(asteroids[i]>0){
                stack.push(asteroids[i]) ;
            }
            while(!stack.isEmpty() && stack.peek()>0 && alive == true && asteroids[i]<0 ){ 
            if( Math.abs(asteroids[i])>stack.peek()){
                stack.pop() ;
                }  
            else if( Math.abs(asteroids[i])==stack.peek()){
                stack.pop() ;
                alive = false ;
                continue ;
                } 
            else if( Math.abs(asteroids[i]) < stack.peek()){
              alive = false ;
              continue ;
                } 
              
            }
            if(asteroids[i]<0 && alive== true ){
                stack.push(asteroids[i]) ;
            }
        }
      
        int[] arr = new int[stack.size()];
            int i = arr.length - 1;
            while (!stack.isEmpty()) {
                arr[i--] = stack.pop();
            }
            return arr ;
    }
}