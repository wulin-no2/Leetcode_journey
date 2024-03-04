class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort based on the first element of subarray
        // if overlapping, remove the interval with the bigger end 
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int slow = 0;
        int fast = 1;
        int count = 0;
        while(fast < intervals.length){
            int[] temp = intervals[slow];
            int[] temp1 = intervals[fast];
            if(temp[1] > temp1[0]){
                // overlap:
                count++;
                if(temp[1] > temp1[1]) {slow = fast; fast++;}
                else fast++;
            }
            else {
                // not overlap:
                slow = fast;
                fast++;
            }
        }
        return count;
    }
}