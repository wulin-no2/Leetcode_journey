class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // the answer is between 1 to biggest element 
        // use binary search tree
        Arrays.sort(piles);
        int n = piles.length;
        int left = 1;
        int right = piles[n - 1] + 1;
        int res = piles[n - 1];
        while(left < right){
            int mid = left + (right - left) / 2;
            int time = 0;
            // caculate time
            for(int pile: piles){
                time += (pile + mid - 1) / mid;
            }
            if(time > h) left = mid + 1;
            else {
                // we might get answer, but try to decrease speed (mid)
                res = Math.min(mid, res);
                right = mid;
            }
        }
        return res;
        
    }
}