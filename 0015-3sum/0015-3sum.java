class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
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
        //from discuss:
        /*
        int target = 0;
        Arrays.sort(nums);
        // need to use hashSet;
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        res.addAll(s);
        return res;
        */
        
    }
}