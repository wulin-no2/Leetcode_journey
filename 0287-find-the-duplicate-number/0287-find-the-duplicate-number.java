class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle using slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];         // Move slow pointer one step
            fast = nums[nums[fast]];   // Move fast pointer two steps
        } while (slow != fast);        // Loop until they meet

        // Phase 2: Find the entry point of the cycle (duplicate number)
        slow = nums[0];                // Reset slow to start
        while (slow != fast) {          // Loop until they meet at the entry
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;  // The duplicate number
        // sort it;
        // see if nums[i] == nums[i + 1]
        /* my approach
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1 ; i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;   
        */
    }
}