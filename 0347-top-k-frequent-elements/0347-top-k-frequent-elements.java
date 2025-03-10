class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // min heap
        // use map to tract the frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        //turn pq into array
        int[] res = new int[k];
        for(int i = 0; i < res.length; i++){
            res[i] = pq.poll().getKey();
        }
        return res;
        
    }
}