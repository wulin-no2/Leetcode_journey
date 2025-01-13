class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // when the latter car has higher speed, they're possible to become a fleet; then they run with the speed of the slower car
        // traverse from end to start

        // calculate their time to end, if the latter car's time is shorter, then they can be a fleet
        int n = position.length;
        // first!!! sort it according to their positions!!
        int[][] cars = new int[n][2];
        for(int i = 0; i < n ; i++){
            cars[i][0] = position[i]; // [position, speed] pair
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b)-> (a[0]-b[0])); // sort it from small position to large
        double[] time = new double[n];
        for(int i = 0 ; i < n ; i++){
            time[i] = (target - cars[i][0]) / (double)cars[i][1];
        }
        int res = 1;
        int currFleet = n - 1;
        for(int i = n - 2 ; i >= 0 ; i--){
            if(time[i] > time[currFleet]) {res++; currFleet = i;}
        }
        return res;
        
    }
}