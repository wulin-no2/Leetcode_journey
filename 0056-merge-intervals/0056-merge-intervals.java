class Solution {
    public int[][] merge(int[][] intervals) {
        // sort them according to first numbers;
        // then each time compare new start with first end, if start > end, add it;
        // else, compare their end, set the lager end as now end; pop one and push one;
        // till the end;
        // maybe we don't need to sort them, just compare? No we have to sort them. or it will be complicated;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        int len = intervals.length;
        // use arrayList to add new intervals; more flexible;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < len; i++){
            int[] last = list.get(list.size() - 1);
            if(intervals[i][0] > last[1]) list.add(intervals[i]);
            else{
                last[1] = Math.max(intervals[i][1], last[1]);
                // list.remove(list.size() - 1);
                // list.add(new int[]{Math.min(intervals[i][0],last[0]), Math.max(intervals[i][1], last[1])});
            }
        }
        // now we get list. how to transfer list to Array;
        return list.toArray(new int[list.size()][2]);
    }
}