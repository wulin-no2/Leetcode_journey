class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i
            if (nums[i] > 0) break; // early stop

            int p1 = i + 1, p2 = n - 1;
            int target = -nums[i];

            while (p1 < p2) {
                int sum = nums[p1] + nums[p2];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                    while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                    p1++; p2--;
                } else if (sum > target) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return res;
    }
}