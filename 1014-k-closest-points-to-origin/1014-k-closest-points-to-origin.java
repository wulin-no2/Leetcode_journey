class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max heap, pop max elements and remain smaller elements
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->distance(b)-distance(a));
        for(int[] point: points){
            pq.offer(point);
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for(int[] i: res){
            int[] temp = pq.poll();
            i[0] = temp[0];
            i[1] = temp[1];
        }
        return res;
        
    }
    public int distance(int[] p){
        return p[0]*p[0]+p[1]*p[1];
    }
}