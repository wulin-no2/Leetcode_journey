class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // traverse the stations
        // 1.record if the whole gas is enough;
        // 2. record if the current gas can make it to the final station;
        int wholeGas = 0;
        int currentGas = 0;
        int start = 0;
        for(int i = 0; i < gas.length ; i++){
            currentGas += gas[i] - cost[i];
            wholeGas += gas[i] - cost[i];
            if(currentGas < 0) {start = i + 1; currentGas = 0;}

        }
        return wholeGas >= 0 ? start : -1;
    }
}