class TimeMap {
    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size();
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int index = left - 1;
        if (index < 0) {
            return "";
        }
        return list.get(index).value;

        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */