class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int k = (left + right) / 2;
            long hours = 0;

            for (int p : piles) {
                hours += Math.ceil((double) p / k);  
            }

            if (hours <= h) {
                result = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return result;
    }
}