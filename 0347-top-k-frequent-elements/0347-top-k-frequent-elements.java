class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // track elements and their frequency, then sort elements base on the frequency
        // use treeMap or priority queue? latter. Because treeMap is sorted on its key, which can't be changed, but now the frequency is changing all the time;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare( a.getValue(), b.getValue()));
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < res.length; i++){
            res[i] = pq.poll().getKey();
        }
        return res;


        
    }
}