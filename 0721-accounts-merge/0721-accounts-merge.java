class Solution {
    /*
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // can't do it. can't identify graph;
        // traverse them. if the name is unique. put in the result
        // if it's not unique. put in another list by their name, then compare;
        
        // 1-pass. traverse unique;
        List<List<String>> res = new ArrayList<>();
        List<List<String>> remain = new ArrayList<>();
        // use a hashmap to finish this process;
        Map<String, List<String>> map = new HashMap<>();
        // o(n);
        for(List<String> l : accounts){
            if(map.containsKey(l.get(0)){
                remain.add(map.get(l.get(0)));
                remain.add(l);
                map.remove(l.get(0));
            }
            else{
                map.put(l.get(0), l);
            }
       }}
      // now we add the map into res;
       for(int i = 0 ; i < map.size(); i++){
           res.add(map.get(i));
       }
       // Now deal with the remain; 2 pointers?        
    }
    */ 
    // solution from neetcode: 
    // hard to know it's dsu. even know, still can't do it
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String, Integer> map = new HashMap<>();  // email -> index of acc
        // put unique emails into map;
        // union duplicate emails in dsu;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                //String name = accounts.get(i).get(0); // didn't use it?

                if(!map.containsKey(email))
                    map.put(email, i);
                else
                    dsu.union(i, map.get(email)); 
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();  // index of acc -> list of emails
        // traverse emails in map.
        // get each email's rootIndex in dsu;
        // add them into merged map<Integer, List<String>>
        for(String email : map.keySet()){
            int index = map.get(email);
            int rootIndex = dsu.find(index);

            if(!merged.containsKey(rootIndex)) 
                merged.put(rootIndex, new LinkedList<String>());
            merged.get(rootIndex).add(email);    
        }
        // convert map to List;
        // use list to store result;
        // use tempList to store each element list;
        List<List<String>> res = new ArrayList<>();  
        for(int i : merged.keySet()){
            List<String> temp = merged.get(i);
            Collections.sort(temp);
            temp.add(0, accounts.get(i).get(0));
            res.add(temp);
        }
        return res;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // Union By Rank
    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return false;
        else if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}