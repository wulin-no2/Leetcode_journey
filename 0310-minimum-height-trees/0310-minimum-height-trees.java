class Solution {
    /*
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // dfs;
        int min = n;
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            int temp = dfs(i, n, n, edges);
            if(min == temp) res.add(i);
            else if(min > temp) {
                min = temp;
                res.clear();
                res.add(i);
            } 
        }
    }
    private int dfs(int i, int remain, int len, int n, int[][] edges){
        if(remain == 0) return len;
        if(i >= 0 && i < n){
            len = 1 + dfs()
            
            
        } 
    }*/
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        // get a preMap for each node;
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // find leaves;
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);
        // 
        while (n > 2) {
            // n is number of non-leave nodes;
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                // trim leaves;
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                // get newLeaves;
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}