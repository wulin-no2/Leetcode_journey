class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // sum(Math.ceiling(pile / res)) <= h
        // get max res
        Arrays.sort(piles);
        int n = piles.length;
        // max res = piles[n - 1];
        int left = 1;
        int right = piles[n-1] + 1;
        while(left < right){
            int mid = (left + right)/2;
            int sum = 0;
            for(int pile: piles){
                sum += Math.ceil((double)pile / mid);
            }
            if(sum <= h) right = mid;
            if(sum > h) left = mid + 1;
        }
        return left;

        
    }
}