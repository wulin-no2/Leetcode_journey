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
         // Process groups
        while (!map.isEmpty()) {
            int firstKey = map.firstKey(); // Always pick the smallest available card
            
            for (int i = 0; i < groupSize; i++) {
                int card = firstKey + i; // Expecting consecutive cards

                if (!map.containsKey(card)) return false; // Cannot form a valid group
                
                // Reduce the count or remove the card from the map
                if (map.get(card) == 1) {
                    map.remove(card);
                } else {
                    map.put(card, map.get(card) - 1);
                }
            }
        }
        return true;
            
    }
}