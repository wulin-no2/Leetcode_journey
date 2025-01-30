class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // each time, select the minimum element that fulfill the consecutive requirement
        // if can't find one bigger than current element, return false;
        // at the end, return true;
        // 1. check length
        if(hand.length % groupSize != 0) return false;
        // 2. use treeMap cause we need to sort the elements and track their frequencies;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // pop into it;
        for(int h : hand) map.put(h, map.getOrDefault(h, 0) + 1);
        // traverse to form our consecutive group:
        while(! map.isEmpty()){
            int small = map.firstKey();
            for(int i = 0; i < groupSize ; i++){
                int key = small + i;
                if(! map.containsKey(key)) return false;
                map.put(key, map.get(key) - 1);
                if(map.get(key)==0) map.remove(key);
            }
        }
        return true;
        
    }
}