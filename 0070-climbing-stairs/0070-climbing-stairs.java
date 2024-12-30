class Solution {
    public int climbStairs(int n) {
        // easy to solve it with dynamic programming
        // we could easily get result from the previous step and the step before that
        // arr[n] = arr[n-1] + arr[n-2]
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            //System.out.println(i + " " + arr[i]);
        }
        return arr[n];
        
    }
}