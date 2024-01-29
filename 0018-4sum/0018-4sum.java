class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // sort it:
        Arrays.sort(nums);
        // use hashSet to store result;
        HashSet<List<Integer>> set = new HashSet<>();
        // just like 3 sum, we have more loop;
        for(int i = 0 ; i < nums.length - 3; i++){
            if(target > 0 && nums[i] > target || target < 0 && nums[i] >= 0) continue;
            // System.out.println("i:" + i);
            for(int j = i + 1; j < nums.length - 2; j++){
                if(target > 0 && nums[i] + nums[j] > target || target < 0 && nums[i] + nums[j] >= 0) continue;
                // System.out.println("j:" + j);
                // 2 pointers;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    // System.out.println("left and right:" + left + " " + right);
                    if(nums[left] + nums[right] + nums[i] + nums[j] == target){
                        set.add(Arrays.asList(nums[left], nums[right], nums[i], nums[j]));
                        right--;
                        left++;
                        // System.out.println("set:" + set);
                    } 
                    else if(nums[left] + nums[right] + nums[i] + nums[j] > target) right--;
                    else left++;
                    // System.out.println("left and right:" + left + " " + right);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }
}