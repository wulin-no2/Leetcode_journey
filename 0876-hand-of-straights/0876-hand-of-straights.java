class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // length of hand should be multiple groupSize
        int n = hand.length;
        if( n % groupSize != 0) return false;
        // use treemap, cause we need elements, their counts, and their order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = n / groupSize;
        while(count > 0){
            int firstKey = map.firstKey();
            // value - 1;
            map.put(firstKey, map.get(firstKey) - 1);
            if(map.get(firstKey)==0) map.remove(firstKey);
            for(int i = 1; i < groupSize; i++){
                if(! map.containsKey(firstKey + i)) return false;
                map.put(firstKey + i, map.get(firstKey + i) - 1);
                if(map.get(firstKey + i)==0) map.remove(firstKey + i);
            }
            count--;
        }
        return true;
            
    }
}