class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack    = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // If minStack is empty, val is the first minimum
        // Otherwise store the smaller of val vs current min
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop(); // Always pop both together
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek(); // Always O(1)
    }
}