class TimeMap {
    // one key with multiple values; (key, value) sorted by timestamp
    // map<key, TreeMap<timestamp, value>> 
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        // Initialize the TreeMap if the key does not exist
        map.putIfAbsent(key, new TreeMap<>());
        // Add the value with its timestamp
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(! map.containsKey(key)) return "";
        // Get the TreeMap for the key
        TreeMap<Integer, String> treeMap = map.get(key);
        // Find the greatest timestamp less than or equal to the given timestamp
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        // If no such timestamp exists, return ""
        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */