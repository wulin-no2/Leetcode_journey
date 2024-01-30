class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
	    // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
	    // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
		    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    
                    right--; 
                    left++;
                }
            }
        }
        return result;
        /* my solution with hashset:
        // use List to store the result;
        // no!!! we should use set to store the result!!! Elements should be unique!!!!
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        // sort it
        Arrays.sort(nums);
        // traverse 
        for(int i = 0 ; i < nums.length ; i ++){
            if (nums[i] > 0) continue;
            // 2 pointers inside;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right){
                if((nums[left] + nums[right]) == - nums[i]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); 
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    set.add(temp);
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] > - nums[i]) right --;
                else left ++;
            }
        }
        res.addAll(set);
        return res;
        */
        
    }
}