class Solution {
    public int minEatingSpeed(int[] piles, int h) {
int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        right += 1; // make it right-open [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            long time = 0;  // use long to prevent overflow
            for (int pile : piles) {
                time += (pile + mid - 1) / mid;  // ceil division
            }

            if (time <= h) {
                right = mid;       // try smaller speed
            } else {
                left = mid + 1;    // need bigger speed
            }
        }

        return left;
    }
}