class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // if the later car uses shorter time to arrive target, then they become a fleet
        // We sort cars based on their positions and walk through them from the nearest car to target
        int n = speed.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b)->Integer.compare(b[0], a[0])); // position big to small
        int res = 0;
        double shortTime = 0;
        for(int[] car: cars){
            double time = (double)(target - car[0]) / car[1];
            if(time > shortTime){
                // new fleet
                res++;
                shortTime = time;
            }
        }
        return res;
        
    }
}