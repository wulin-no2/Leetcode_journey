class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // use list get result;
        List<List<Integer>> res = new ArrayList<>();
        // sort it;
        Arrays.sort(nums);
        // trimming:
        if(nums[nums.length - 1] < 0) return res;
        // 2 pointers
        for(int i = 0; i < nums.length - 2; i++){
            // trimming:
            if(nums[i] > 0) break;
            if(i > 0 && nums[i]==nums[i-1]) continue;
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right]==target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left]==nums[left-1]) left++;
                    while(left < right && nums[right]==nums[right+1]) right--;
                }
                while(left < right && (nums[left] + nums[right] < target)) left++;
                while(left < right && (nums[left] + nums[right] > target)) right--;
            }
        }
        return res;
    }
}