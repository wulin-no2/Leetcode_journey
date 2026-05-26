class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use map to track the elements and their frequencies map<element, frequency>
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // use pq to get top k(maxHeap by the frequencies)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
        }
        int[] res = new int[k];
        while(k > 0){
            res[k - 1] = pq.poll().getKey();
            k--;
        }
        return res;

        
    }
}