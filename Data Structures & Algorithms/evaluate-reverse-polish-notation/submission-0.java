class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b);        // Java int division truncates toward zero ✓
                }
                default  -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}