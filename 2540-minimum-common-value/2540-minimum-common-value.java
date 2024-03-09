class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // 2 pointers;
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]) return nums1[i];
            while(nums1[i] > nums2[j]){
                j++;
                if(j == nums2.length) return -1;
            }
            while(nums1[i] < nums2[j]){
                i++;
                if(i == nums1.length) return -1;
            }
        }
        return -1;
    }
}