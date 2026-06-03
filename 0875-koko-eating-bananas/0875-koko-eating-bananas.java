class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // the answer is between 1 to biggest element 
        // use binary search 
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max + 1; // [left, right)

        while(left < right){
            int mid = left + (right - left) / 2;
            long time = 0;
            // caculate time
            for(int pile: piles){
                time += (pile + mid - 1) / mid;
            }
            if(time > h) left = mid + 1;
            else {
                // we might get answer, but try to decrease speed (mid)
                // res = Math.min(mid, res); // we don't need it, cause left is the answer
                right = mid;
            }
        }
        return left;
        
    }
}