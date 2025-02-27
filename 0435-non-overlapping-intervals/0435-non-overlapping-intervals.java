class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // the key idea:
        // sort the intervals by their end time, keep the one with the smallest end when overlapping.
        // Cause we can give more space to future intervals
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int n = intervals.length;
        int count = 0;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int[] first = list.get(list.size() - 1); 
            int[] second = intervals[i];
            // if overlapping, keep the one with the smaller end
            if(first[1] > second[0]) {
                int x = first[0];
                int y = Math.min(first[1], second[1]);
                list.set(list.size() - 1, new int[]{x, y});
                count++;
            }
            // else, put it in the list
            else list.add(intervals[i]);
        }
        return count;



        
    }
}