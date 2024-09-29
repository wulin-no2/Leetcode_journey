class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // traverse
        // use heap to store points and their distances to the origin
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(distance(b),distance(a)));
        
        for(int[] point: points){
            // add element into heap
            pq.offer(point);
            // remove redundant element
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[k][];

        // get top k elements from big heap:
        while(k > 0){
            result[k-1] = pq.poll();
            k--;
        }
        // return
        return result;
    }
    // helper function 
    public int distance(int[] i){
        return i[0]*i[0] + i[1]*i[1];
    }
}