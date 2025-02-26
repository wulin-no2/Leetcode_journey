class Solution {
    public int[][] merge(int[][] intervals) {
        // overlapping means if we sort them based on their first elements,
        // the latter interval's first element <= former interval's last element
        if (intervals.length == 0) return new int[0][];
        
        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = res.get(res.size() - 1);
            int[] current = intervals[i];

            // Check if intervals overlap
            if (current[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], current[1]); // Merge intervals
            } else {
                res.add(current);
            }
        }
        
        return res.toArray(new int[res.size()][]);
        
    }
}