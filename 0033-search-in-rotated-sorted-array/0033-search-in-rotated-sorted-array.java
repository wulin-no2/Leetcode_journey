class Solution {
    public int search(int[] nums, int target) {
        /* can't make it out;
        // binary search;
        // left part always larger than right part;
        // compare target with nums[0], see it's in left part or right part first;
        // then every time, cut half and compare with the other side;
        int n = nums.length;
        // watch out the boundary case: n = 1;
        if(n == 1 && target == nums[0]) return 0;
        if(n == 1 && target != nums[0]) return -1;
        int low = 0;
        int high = n - 1;
        /*int k = nums[0];
        // binary search find k first;( nums[i - 1] > nums[i] return i;)
        // then binary search find target;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid >= 1){
                if(nums[mid - 1] > nums[mid]) k = mid;
                if(nums[mid] > nums[low]) low = mid;
                else high = mid;
            }
        }
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == nums[low]) return low;
            if(target < nums[low]){// t is in right part;
                if(target == nums[mid]) return mid;
                if(nums[mid] > nums[low]){ // mid in left part;
                    low = mid;
                }else{ // mid is left than t;
                    low = mid;
                }
            }
            else{ // t is in left part;
                if(target == nums[mid]) return mid;
                if(target < nums[mid]) // t is left of mid ,change high;
                
            }
            
        }
        return -1;
        */
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
            
            
    }
}