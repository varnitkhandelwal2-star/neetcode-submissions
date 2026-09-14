class MinStack {
Stack<Integer> mainStack = new Stack<>() ;
Stack<Integer> minStack = new Stack<>() ;
    public MinStack() {
        
    }
    
    public void push(int val) {
        mainStack.push(val) ;
       if(minStack.isEmpty() || val <= minStack.peek() ) {
        minStack.push(val) ;
       }
       else {
        minStack.push(minStack.peek()) ;
       }
    }
    
    public void pop() {
        mainStack.pop() ;
        minStack.pop() ;
    }
    
    public int top() {
        int top = mainStack.peek() ;
        return top ;
    }
    
    public int getMin() {
        int min = minStack.peek() ;
        return min ;
    }
}
