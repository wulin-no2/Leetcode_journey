class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // traverse intervals. for each interval,compare it with newInterval
        // 3 conditions:
        // 1. interval[1] > newInterval[0], put interval into result list
        // 2. interval[0] < newInterval[1], put newInterval into res, then put interval in
        // 3. overlapping
        // 3.1. put [Math.min(interval[0], newInterval[0]), Math.max(interval[0], newInterval[0])] into res
        // we can first put newInterval into res, each time get last element of list and compare with interval.
        
        List<int[]> res = new ArrayList<>();
        
        for(int[] interval: intervals){
            if(interval[1] < newInterval[0]) res.add(interval);
            else if(interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = interval; // why???
            }
            else{ // merge them
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
        
    }
}