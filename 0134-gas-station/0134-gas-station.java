class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // we traverse from the 1st station to the last station
        // at each station, we check:
        // 1. if the currentTank is < 0, which means the start point is invalid
        // 2. if the wholeTank is < 0, which means there is no valid start point
        int startPoint = 0;
        int currentTank = 0;
        int wholeTank = 0;
        for(int i = startPoint; i < gas.length ; i++){
            currentTank += gas[i] - cost[i];
            wholeTank += gas[i] - cost[i];
            if(currentTank < 0) { startPoint = i + 1; currentTank = 0;}
            // System.out.println("index:" + i + "whole: "+ wholeTank + "current: " + currentTank);
            
        }
        return wholeTank < 0? -1 :startPoint;
        
    }
}