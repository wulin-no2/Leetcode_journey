class Solution {
    public int maxArea(int[] height) {
        // we can try go inward from two ends 
        // now we have a start
        // then we move the shorter one if we find a better solution
        // remember the amount
        int p1 = 0;
        int p2 = height.length - 1;
        int res = (p2 - p1) * Math.min(height[p1], height[p2]);
        while(p1 < p2){
            while((p1 < p2) && (height[p1] < height[p2])){
                p1++;
                res = Math.max(res, (p2 - p1) * Math.min(height[p1], height[p2]));
            }
            while((p1 < p2) && (height[p1] >= height[p2])){
                p2--;
                res = Math.max(res, (p2 - p1) * Math.min(height[p1], height[p2]));
            }
        }
        return res;
    }
}