class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // we sort the elements based on their frequencies
        // map to store key value pairs map <num, frequency>

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // then sort the EntrySet based on values
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(),a.getValue()));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
        }
        // then return top k elements of this keySet
        int[] res = new int[k];
        while(k > 0){
            res[k-1] = pq.poll().getKey();
            k--;
        }
        return res;

        
    }
}