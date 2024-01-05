class Solution {
    public int maxArea(int[] height) {
        // analyze:
        // if the two lines' end points are(i1, height[i1]),(i2, height[i2]),
        // the amount of water should be (i2 - i1) * Math.min(height[i1],height[i2])
        // we can get the result step by step;
        // each step, we need to compare: height[i] * length with the current maximum amount; the height[i] must be used.
        
        
        // no!! the above solution is wrong.
        // we should use two pointers approach and move them inward to find a high line and make the area maximum.
        // define 2 pointers at the 2 ends of the array.
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while(left < right){
            // define the width and height and area;
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            max = Math.max(max, area);
            
            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                // why if it's the same, move both?
                // 
                left++;
                right--;
            }
        }
        return max;
    }
}