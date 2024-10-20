class Solution {
    public int maxArea(int[] height) {
        // 2 pointers inward
        // move the shorter one to longer and update
        int left = 0;
        int right = height.length - 1;
        int res = Math.min(height[left],height[right]) * (right - left);
        while(left < right){
            // compare
            if(height[left] < height[right]) left++; // move left   
            else right--;
            //update
            res = Math.max(res, Math.min(height[left],height[right]) * (right - left));
        }
        return res;
    }
}