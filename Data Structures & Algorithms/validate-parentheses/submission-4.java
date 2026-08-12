class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
            if ( s == null || s.isEmpty() ){
                return true ;
            }
        for (char c : s.toCharArray()) { 
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c); 
            }
            else if (map.containsKey(c) ){
                if (stack.isEmpty() || stack.peek()!=map.get(c)){
                    return false ;
                }
                stack.pop() ;
            }

        }
        return stack.isEmpty() ;
    }
}
