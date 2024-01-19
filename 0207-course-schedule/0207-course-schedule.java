class Solution {
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
        // traverse numCourses
        // for each course, find all their pre, which means [course, j]
        // record all the j into an array
        // then for all the j, if there exists[j, course], return false;
        // return true. finally;
        
        // 2-pass;
        // 1 pass, find all the j for i;
        // create a list to store all the result of j lists;
        /* brute force solution:
        List<List> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i ++){
            List<Integer> temp = new ArrayList<>();// use to store all the j for [course, j];
            for(int j = 0 ; j < prerequisites.length ; j ++){
                if(prerequisites[j][0] == i) temp.add(prerequisites[j][1]);
            }
            list.add(temp);
        }
        // now we get list. we can find is there exists[j, course] in the pre;
        for(int i = 0; i < list.size(); i++){
            List<Integer> temp = list.get(i);
            for(int t : temp){
                for(int j = 0 ; j < prerequisites.length ; j ++){
                    if(prerequisites[j][0] == t && prerequisites[j][1] == i) return false;
                }
            }
        }
        return true; 
        */
        
    //}
    // DFS with GPT: need to see once more;
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (isCyclic(course, graph, visited, recStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int course, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        if (recStack[course]) {
            return true;
        }
        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        recStack[course] = true;

        List<Integer> children = graph.get(course);
        for (Integer child : children) {
            if (isCyclic(child, graph, visited, recStack)) {
                return true;
            }
        }

        recStack[course] = false;
        return false;
    }
    */
    // code from neetcode:
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {
        if (visited[curr] == 2) {
            return true;
        }

        visited[curr] = 2;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            if (visited[adj.get(curr).get(i)] != 1) {
                if (isCyclic(adj, visited, adj.get(curr).get(i))) {
                    return true;
                }
            }
        }
        visited[curr] = 1;
        return false;
    }
}