class Solution {
    public int[][] merge(int[][] intervals) {
        // overlapping means if we sort them based on their first elements,
        // the latter interval's first element <= former interval's last element
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        res.add(intervals[0]);
        for(int i = 1 ; i < n; i++){
            int former = res.get(res.size()-1)[1];
            int latter = intervals[i][0];
            if(latter <= former) {
                int x = res.get(res.size()-1)[0];
                int y = Math.max(intervals[i][1], res.get(res.size()-1)[1]);
                res.set(res.size()-1, new int[]{x,y});
                //res.add();
            }
            else {
                res.add(intervals[i]);
                }
        }
        return res.toArray(new int[res.size()][2]);
        
    }
}