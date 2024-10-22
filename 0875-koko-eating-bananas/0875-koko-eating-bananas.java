class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid;  // Try smaller k
            } else {
                left = mid + 1;  // Increase k
            }
        }
        return left;
    }

    // Helper method to calculate the maximum pile size
    private int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    // Helper method to check if Koko can eat all bananas with speed k in h hours
    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // ceil(pile / k)
        }
        return hours <= h;
    }
}