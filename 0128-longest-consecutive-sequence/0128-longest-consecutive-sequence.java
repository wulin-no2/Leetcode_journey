class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)  return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int res = 1;
        for(int i : set){
                if(! set.contains(i - 1)){
                    int curr = 1;
                    // for each element of set, check if it has a bigger number:
                    while(set.contains(i + 1)) {
                        curr++;
                        i++;
                    }
                    res = Math.max(res, curr);
                }
        }
        return res;
    }
}