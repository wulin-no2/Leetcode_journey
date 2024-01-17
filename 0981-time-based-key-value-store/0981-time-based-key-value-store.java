class TimeMap {
    // use HashMap<Node, String> map to store the value;
    // can't do it. TLE
    /*
    HashMap<Node, String> map = new HashMap<>();
    Node node;
    class Node{
        String nkey;
        int nstamp;
        public Node(){
            nkey = "";
            nstamp = 0;
        }
        public Node(String nkey, int nstamp){
            this.nkey = nkey;
            this.nstamp = nstamp;
        }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return nstamp == node.nstamp &&
                   Objects.equals(nkey, node.nkey);
        }
        public int hashCode() {
            return Objects.hash(nkey, nstamp);
        }
    }

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        Node temp = new Node(key, timestamp);
        map.put(temp, value);
    }
    
    public String get(String key, int timestamp) {
        for(int i = timestamp ; i >= 0; i--){
            Node nodeKey = new Node(key, i);
            if(map.containsKey(nodeKey)) return map.get(nodeKey);
        }
        return ""; 
    }
    */


    private HashMap<String, ArrayList<Pair>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    class Pair {
        int timestamp;
        String val;

        Pair(int timestamp, String val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    public void set(String key, String value, int timestamp) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(new Pair(timestamp, value));
        } else {
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(timestamp, value));
            hashMap.put(key, arr);
        }
    }

    public String get(String key, int timestamp) {

        String cand = "";

        if (hashMap.containsKey(key)) {
            ArrayList<Pair> arr = hashMap.get(key);
            int low = 0, high = arr.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int timeVal = arr.get(mid).timestamp;
                if (timeVal == timestamp) {
                    return arr.get(mid).val;
                } else if (timeVal < timestamp) {
                    cand = arr.get(low).val;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return cand;
    }
    
    
    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */