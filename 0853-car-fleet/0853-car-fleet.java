class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int res = 0;
        
        // Step 1: Calculate the positions and times to reach the target
        double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];  // Position of the car
            cars[i][1] = (double)(target - position[i]) / speed[i];  // Time to reach target
        }

        // Step 2: Sort cars by their position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        // Step 3: Merge cars into fleets
        double leadTime = 0;  // Initialize lead time as 0
        for (int i = 0; i < cars.length; i++) {
            if (cars[i][1] > leadTime) {  // If current car's time is longer than lead time, it's a new fleet
                res++;  // Increment fleet count
                leadTime = cars[i][1];  // Update the lead time to this car's time
            }
        }

        return res;  // Return the total number of fleets
    }
}