class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int n = position.length;
        double[][] cars = new double[n][2];
        
        // calculate arrival time
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // position
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time
        }

        // sort based on position
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double prev = 0.0;
        
        // traverse from end to start
        for (int i = 0; i < n; i++) {
            double cur = cars[i][1];  // current arrival time
            
            // if longer than last car, we get a new fleet
            if (cur > prev) {
                fleets++;
                prev = cur;
            }
        }
        
        return fleets;
    }
}