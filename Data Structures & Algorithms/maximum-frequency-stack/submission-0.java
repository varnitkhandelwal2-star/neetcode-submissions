class FreqStack {
    HashMap<Integer, Stack<Integer>> groupMap;
    HashMap<Integer, Integer> freqMap;
    int maxFreq;

    public FreqStack() {
        groupMap = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        groupMap.computeIfAbsent(freq, k -> new Stack<>()).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> st = groupMap.get(maxFreq);
        int val = st.pop();
        freqMap.put(val, freqMap.get(val) - 1);
        if (st.isEmpty()) maxFreq--;
        return val;
    }
}