class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // to avoid duplicate result, we sort it first
        Arrays.sort(nums);
        // fix one number, then use 2 pointers to find result;
        // jump the duplicate elements in same position:
        for(int i = 0; i < nums.length-2;i++){
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[right] < 0) break;
                if(nums[left] + nums[right] + nums[i]==0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left]==nums[left - 1]) left++; // skip dulpicate
                    while(left < right && nums[right]==nums[right + 1]) right--; // skip dulpicate
                } else if(left < right && nums[left] + nums[right] + nums[i] < 0) left++;
                else right--;
            }
        }
        return res;

        
        
    }
}