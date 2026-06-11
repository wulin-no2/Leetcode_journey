class TimeMap {
    // we need a map<key,<timestamp,value>>
    // for <timestamp, value>, timestamp in already in order
    // we just need to find a timestamp which is <= timeValue that's retrieved 
    // so in this <timestamp, value> collection, we do binary search to find the first F - 1
    // which feels like TTT[T]FFFFF, we get the last T or the first F - 1
    Map<String, ArrayList<Pair>> map = new HashMap<>();
    class Pair {
        Integer timestamp;
        String value;
        public Pair(Integer timestamp, String value) {
            this.timestamp = timestamp; // problem 1
            this.value = value;
        }
    }

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<Pair>()).add(pair); // problem 2
    }
    
    public String get(String key, int timestamp) {
        // get collection first
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        // binary search
        int left = 0;
        int right = list.size(); // problem 3
        while(left < right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp > timestamp) right = mid;
            else left = mid + 1;
        }
        if (left == 0) return ""; // problem 4
        return list.get(left - 1).value;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */