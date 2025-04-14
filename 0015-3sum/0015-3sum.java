class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 2 pointers. fix the first number, then 2 pointers inward
        // but sort it first in order to user 2 pointers and avoid duplicated triplets;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int first = 0;
        while(first < nums.length - 2){
            // trim when the first element is already bigger than 0;
            if(nums[first] > 0) break;
            while(first > 0 && first < nums.length - 2 && nums[first]==nums[first-1]) first++;
            // 2 pointers;
            int left = first + 1;
            int right = nums.length - 1;
            while(left < right){
                if(left < right && nums[left] + nums[right] + nums[first] > 0) right--;
                else if(left < right && nums[left] + nums[right] + nums[first] < 0) left++;
                else if(left < right && nums[left] + nums[right] + nums[first] == 0){
                    res.add(Arrays.asList(nums[left], nums[right], nums[first]));
                    left++;
                    right--;
                    // avoid duplicated left & right
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                else break;
            }
            // move first
            first++;
        }
        return res;
        
    }
}