class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // analyze:
        // 1) create an int[][] res to store the result;
        // 2) for each point, the distance is i*i + j*j;
        // 3) get all the distances of the points;
        // 4) sort the distances;
        // 5) return the Kth points(include same distance point);
        
        // There must a comparator, which is inner class:
        Comparator<int[]> pointComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                int distanceSq1 = p1[0] * p1[0] + p1[1] * p1[1];
                int distanceSq2 = p2[0] * p2[0] + p2[1] * p2[1];
                return Integer.compare(distanceSq1, distanceSq2);
            }
        };
            
        Arrays.sort(points, pointComparator);
        return Arrays.copyOfRange(points, 0, k);
        
        

        
    }
}