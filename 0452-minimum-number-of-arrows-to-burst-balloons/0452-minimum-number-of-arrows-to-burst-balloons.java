class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort it at first;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        // merge it if they overlap with each other;
        List<List> list = new ArrayList<>();
        // 2 pointers;
        int p = 0;
        while(p < points.length){
            int[] temp = points[p];
            // merge with last element of list;
            if(list.size() == 0) {
                List<Integer> pair = new ArrayList();
                pair.add(temp[0]);
                pair.add(temp[1]);
                list.add(pair);
            }
            int temp1 = (int)list.get(list.size() - 1).get(1);
            
            // if overlap, store their overlap:
            if(temp1 >= temp[0]) {
                List<Integer> pair = new ArrayList();
                pair.add(temp[0]);
                pair.add(Math.min(temp[1],temp1));
                list.remove(list.size() - 1);
                list.add(pair);
                p++;
            }
            else {
                List<Integer> pair = new ArrayList();
                pair.add(temp[0]);
                pair.add(temp[1]);
                list.add(pair);
                p++;
            }
        }
        return list.size();
    }
}