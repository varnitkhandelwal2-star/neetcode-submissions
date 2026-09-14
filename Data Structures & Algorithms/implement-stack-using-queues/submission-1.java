class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }

    public void push(int x) {
        q.add(x);

        int n = q.size();

        for (int i = 0; i < n - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}