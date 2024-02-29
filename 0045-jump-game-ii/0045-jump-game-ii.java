class Solution {
    public int jump(int[] nums) {
        // for each position, record the smallest count we reach here, and the far index we can reach;

        int count = 0;
        int preFar = 0;
        int far = 0;
        for (int i = 0; i <= preFar && preFar < nums.length - 1; i++) {
            far = Math.max(far , i + nums[i]);
            // if index already reach the boundary of preFar, update preFar and count;
            if (i == preFar) {preFar = far; count++;}
        }
        return count;
    }
}