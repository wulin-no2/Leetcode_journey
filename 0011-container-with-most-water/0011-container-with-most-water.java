class Solution {
    public int maxArea(int[] height) {
        // start with the largest broadth, then 2 pointers inward
        // only when we find higher height, the area is likely to get bigger
        // how to find igher height? move the shorter one inward to find a bigger one

        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[right], height[left]) * (right - left);
        while(left < right){
            if(height[left] <= height[right]){
                left++;
                if(height[left] > height[left-1]){
                    max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
                }
            }else{
                right--;
                if(height[right] > height[right + 1]){
                    max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
                }
            }
        }

        return max;
    }
}