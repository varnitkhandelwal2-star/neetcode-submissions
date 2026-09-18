class Solution {
    public String decodeString(String s) {
       Stack< String> stack = new Stack<>() ;
        for(int i = 0; i < s.length(); i++){
    if(s.charAt(i) != ']'){
        stack.push(String.valueOf(s.charAt(i)));
    } else {
        String str = "" ;
        while(!stack.peek().equals("[")){
            str = stack.pop() + str ;
        }
    stack.pop();
    String num = stack.pop();
while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
    num = stack.pop() + num;
}
    String repeated = "";
    for(int j = 0; j < Integer.parseInt(num); j++){
        repeated += str;
    }
    
    stack.push(repeated);

    }
   }
   String result = "";
while(!stack.isEmpty()){
    result = stack.pop() + result;
}
return result;
 }
}