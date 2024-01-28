class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // use arraylist to store result;
        List<Integer> list = new ArrayList<>();
        // result must be unique, we can use hashset;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length ; i ++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length ; i ++){
            if(set.contains(nums2[i]) && !list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++){
            res[i] = list.get(i);  
        }
        return res;
    }
}