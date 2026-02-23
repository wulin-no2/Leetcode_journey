class Solution {
    public int maxArea(int[] height) {
        // two pointers inward
        // move the shorter one, if we can find a taller one and make result bigger, then move it
        int p1 = 0;
        int p2 = height.length - 1;
        int res = 0; 
        while(p1 < p2){
            res = Math.max(Math.min(height[p2], height[p1]) * (p2 - p1), res);
            if(height[p2] > height[p1]){
                // move p1
                p1++;
            }
            else p2--;
        }
        return res;
    }
}