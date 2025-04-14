class Solution {
    public int maxArea(int[] height) {
        // 2 pointers inward
        // move the shorter one when we find a higher line
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        res = Math.min(height[left], height[right]) * (right - left);
        while(left < right){
            int leftHeight = height[left];
            int rightHight = height[right];
            if(left < right && leftHeight <= rightHight) left++;
            else if(left < right && leftHeight > rightHight) right--;
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
        }
        return res;
    }
}