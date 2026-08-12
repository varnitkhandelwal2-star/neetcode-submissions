class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>() ;
        for(String token : tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*")){
                stack.push(Integer.parseInt(token)) ;
            }
            else{
                int a = stack.pop() ;
                int b = stack.pop();

                   switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(b - a); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(b / a); break;
                }
            }
        }
            return stack.pop() ;
    }
}
