class KthLargest {
    // min heap with size k
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size = 0;

    public KthLargest(int k, int[] nums) {
        size = k;
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > this.size) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */