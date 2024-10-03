class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort
        Arrays.sort(nums); // n log n
        // use list to record result
        List<List<Integer>> res = new ArrayList<>();
        // 3 pointers. fix one, then use 2 pointers to find solution
        for(int i = 0 ; i < nums.length - 2 ; i++){
            // check duplicate
            if(i != 0 && nums[i]==nums[i-1]) continue;
            int sumForTwo = 0 - nums[i];
            // 2 pointers to find sumForTwo
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[j] + nums[k]==sumForTwo){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j]==nums[j-1]) j++;
                    while(j < k && nums[k]==nums[k+1]) k--;
                } 
                else if(nums[j] + nums[k] > sumForTwo) {
                    k--;
                    while(j < k && nums[k]==nums[k+1]) k--;
                }
                else {
                    j++;
                    while(j < k && nums[j]==nums[j-1]) j++;
                }
            }
        }
        return res;
    }
}