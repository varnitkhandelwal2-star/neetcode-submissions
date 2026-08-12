
class Solution {
    public int leastInterval(char[] tasks, int n) {
            // frequency array
        int[] freq = new int[26];
        for(char t : tasks) {
            freq[t - 'A']++;
        }

        // find max frequency
        int f = Arrays.stream(freq).max().getAsInt();

        // count tasks with max frequency
        int count = 0;
        for(int x : freq) {
            if(x == f) count++;
        }

        // formula
        int part1 = (f - 1) * (n + 1) + count;
        int part2 = tasks.length;

        return Math.max(part1, part2);
    }
}
