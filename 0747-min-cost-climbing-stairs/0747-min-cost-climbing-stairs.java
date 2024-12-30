class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // use dp to solve it
        // arr[i] = Math.min(arr[i-1]+cost[i-1], arr[i-2]+cost[i-2]);
        // i is the top, i-1 is the last index
        int n = cost.length;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = Math.min(cost[0], cost[1]);
        for(int i = 3; i<=n; i++){
            arr[i] = Math.min(arr[i-1]+cost[i-1], arr[i-2]+cost[i-2]);
        }
        return arr[n];
        
    }
}