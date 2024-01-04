class Solution {
    public void sortColors(int[] nums) {
        // similar to the partition algorithm of quickSort
        // use 3 pointers and traverse with the middle pointer;
        // if nums[mid] is 0, swap nums[mid] with nums[low], low++, mid++;
        // if nums[mid] is 1, mid++;
        // if nums[mid] is 2, swap nums[mid] with nums[high], high--;
        
        int low = 0, mid = 0, high = nums.length - 1;
        int temp;

        for (mid = 0; mid <= high;) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                // Swap nums[mid] and nums[high]
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}