class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // the key idea:
        // sort the intervals by their end time, keep the one with the smallest end when overlapping.
        // Cause we can give more space to future intervals
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int n = intervals.length;
        int count = 0;
        int prevEnd = intervals[0][1]; // First interval's end 
        for(int i = 1; i < n; i++){
            // if overlapping, keep the one with the smaller end
            if(prevEnd > intervals[i][0]) count++;
            
            // else, put it in the list
            else prevEnd = intervals[i][1];
        }
        return count;



        
    }
}