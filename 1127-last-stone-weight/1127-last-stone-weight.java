class Solution {
    public int lastStoneWeight(int[] stones) {
        // every time ,we get the 2 heaviest stones;
        // use max heap to maintain data;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b, a));
        for(int stone: stones) pq.offer(stone);
        // get 2 each time
        while(pq.size() >= 2){
            int i = pq.poll(); // bigger
            int j = pq.poll();
            if(i != j) pq.offer(i - j);
        }
        return pq.size()==0? 0: pq.poll();
        
    }
}