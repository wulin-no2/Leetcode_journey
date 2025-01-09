class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // record the nums accorcing to their frequences
        // (num, frequency), sorted it by frequency;
        // TreeMap can sort values by keys, priority queue can sort values by a comparator
        Map<Integer, Integer> map = new HashMap<>();
        // get (num, prequency)
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // use pq to sort entrys of map
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            // keep the size of pq into k
            if(pq.size() > k) pq.poll();
        }

        // get top k entrys with larger frequencies
        // convert them into int[]
        int[] res = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: pq){
            res[i] = entry.getKey();
            i++;
        }
        return res;
        
    }
}