class TimeMap {
    // each key is associated with a list/map including several values and timestamps
    // which can be retrived according to the number of value, so TreeMap
    // Map<String, TreeMap<Integer, String>>
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(! map.containsKey(key)) return "";
        TreeMap<Integer, String> treeMap = map.get(key);
        Integer keyTreeMap =treeMap.floorKey(timestamp);
        if (keyTreeMap == null) return "";
        return treeMap.get(keyTreeMap);
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
