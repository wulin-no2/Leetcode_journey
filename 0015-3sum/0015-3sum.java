class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /* almost do it, chose a wrong data structure;
        // sort it;
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n - 1] < 0 || nums[0] > 0) return null;
        // we need to search, so arraylist is better;
        ArrayList<Integer> arr = new ArrayList(Arrays.asList(nums));
        ArrayList<List<Integer>> res = new ArrayList<>();
        // for the 3 num, they must ly on both sides of 0;
        // we can use 2 pointers from 2 ends, and see if the 3rd number exists;
        int i = 0;
        int j = arr.size() - 1;
        while(i < j){
            int sum2 = arr.get(i) + arr.get(j);
            int num3 = arr.indexOf(-sum2);
            if(num3 != -1){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr.get(i));
                temp.add(arr.get(j));
                temp.add(arr.get(num3));
                res.add(temp);
                arr.remove(num3);
                i++;
                j--;
            }else{
                i++;
            } 
        }
        return res;  
        */
        
        //from discuss:
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
        
        
    }
}