class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length; // [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half [left..mid] is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;          // target in left sorted half
                } else {
                    left = mid + 1;       // target in right half
                }
            }
            // Right half [mid..right-1] is sorted
            else {
                if (nums[mid] < target && target <= nums[right - 1]) {
                    left = mid + 1;       // target in right sorted half
                } else {
                    right = mid;          // target in left half
                }
            }
        }
        return -1;
    }
}