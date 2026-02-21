class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // fix one pointer, then move two other pointers inward
        // sort it first
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 2){
            int target = - nums[i];
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while(p1 < p2){
                // compare 
                if(nums[p1] + nums[p2] == target) {
                    res.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    // remove duplicate
                    while(p1 < p2 && nums[p1] == nums[p1 + 1]) {p1++;}
                    while(p1 < p2 && nums[p2] == nums[p2 - 1]) {p2--;}
                    p1++;
                    p2--;
                } else if (nums[p1] + nums[p2] > target){
                    p2--;
                }
                else {
                    p1++;
                }
            }
            // remove duplicate for p0
            while(i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
            i++;
            // System.out.println("3 -- nums p0 p2 p2 are: " + nums[i] + " " + nums[p1] + " " + nums[p2]);
        }
        return res;
    }
}