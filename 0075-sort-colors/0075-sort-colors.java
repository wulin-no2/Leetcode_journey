class Solution {
    public void sortColors(int[] nums) {
        // similar to the partition algorithm of quickSort
        // first, use a pointer from index 0 on to traverse, find the elements that > 1 and swap to the right part;
        // use another pointer from rightmost on, record the position of the just swapped elements;
        // second, do it again to swap all the 1 elements to the right part;
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