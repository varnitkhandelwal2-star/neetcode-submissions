class TimeMap {

    private Map<String, List<int[]>> timestamps;
    private Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values     = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key)) return "";

        List<int[]> times = timestamps.get(key);
        List<String> vals = values.get(key);

        int left = 0, right = times.size() - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times.get(mid)[0] <= timestamp) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans == -1 ? "" : vals.get(ans);
    }
}