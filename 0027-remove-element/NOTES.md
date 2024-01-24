​Approach 1 - 2 pointers;
One pointer for traversing the array. The other one for record the values that not equal to val;
Time Complexity = O(n)
Space Complexity = O(1)

Approach 2 - Sort + Binary Search + Swap;
Time Complexity = O(nlogn)
Space Complexity = O(1)

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;
        int left = -1; // Initialize to -1 to indicate not found
        int right = -1; // Initialize to -1 to indicate not found

        // Find the range where val exists
        while (low <= high) {
            int mid = (low + high) / 2;
            if (val == nums[mid]) {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == val) { // find left boundary
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == val) { // find right boundary
                    right++;
                }
                break; // Exit the loop once the range is found
            }
            if (val > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }

        if (left == -1) return nums.length; // val not found in the array

        for (int i = right + 1; i < nums.length; i++) {
            nums[i - (right - left + 1)] = nums[i];
        }
        return nums.length - (right - left + 1);
    }
}
