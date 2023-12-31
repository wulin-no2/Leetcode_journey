class Solution {
    public int maxSubArray(int[] nums) {
        // analyze:
        // we can use kadane's algorithm;
        // use 2 int and 2 LinkedList to store arrays;
        // 1) int max_ending_here
        // 2) int max
        // update step by step
        
        /*
        int maxEndingHere = nums[0];
        //LinkedList<Integer> cddArray = new LinkedList<>();
        //cddArray.add(nums[0]);
        
        int max = nums[0];
        //LinkedList<Integer> maxArray = new LinkedList<>();
        //maxArray.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++){
            if(maxEndingHere + nums[i] > nums[i]){
                maxEndingHere = maxEndingHere + nums[i];
                //cddArray.add(nums[i]); 
            }else{
                maxEndingHere = nums[i];
                //cddArray = null;
                //cddArray.add(nums[i]); 
            }
            
            if(max < maxEndingHere){
                max = maxEndingHere;
                //maxArray = cddArray;
            } 
        }
        return max;
        */
        
        
        // there are other 2 approaches;
        // Dynamic Programming
        int storage []=  new int[nums.length];
        int max  =  nums[0];
        storage[0] =  nums[0];
        for(int i = 1; i < nums.length; i++){
           storage[i] = Math.max(storage[i-1] + nums[i], nums[i]);
           if(storage[i] > max){
               max = storage[i];
           }
        }
        return max;     
    }
}