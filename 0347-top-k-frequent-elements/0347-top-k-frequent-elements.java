class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. use map to record elements and their frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        // 2. use priority queue to sort map.entry (min heap) with a comparator based on value of entry
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            // 2.1. once queue.size() > k, poll() to ensure remaining top k frequent elements
            if(pq.size() > k) pq.poll();
        }
        
        // 3. convert priority queue into array result;
        int[] res = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: pq){
            res[i] = entry.getKey();
            i++;
        }
        return res;
        
    }
}