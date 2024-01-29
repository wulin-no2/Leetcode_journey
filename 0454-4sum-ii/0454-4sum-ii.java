class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // we need to know all the combitions of the tuples
        // first, we can get the first 2 arrays sum results and
        // the last 2 arrays sum results;
        // then, it's 2 sum question now.
        // we can use map to store them. cause we need to know the counts;
        // TC = O(n^2) , SC = O(n) 
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i : nums1){
            for(int j : nums2){
                map1.put( i + j, map1.getOrDefault( i + j , 0) + 1);
            }
        }
        for(int i : nums3){
            for(int j : nums4){
                map2.put( i + j, map2.getOrDefault( i + j , 0) + 1);
            }
        }
        // HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(Integer i : map1.keySet()){
            int temp = 0 - i;
            if(map2.containsKey(temp)) res += map1.get(i) * map2.get(temp);
        }
        return res;  
    }
}