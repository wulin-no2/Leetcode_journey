class TimeMap {
    // private Map<String, TreeMap<Integer, String>> map;

    //     public TimeMap() {
    //         map = new HashMap<>();
    //     }
        
    //     public void set(String key, String value, int timestamp) {
    //         map.computeIfAbsent(key, k -> new TreeMap<>())
    //         .put(timestamp, value);
    //     }
        
    //     public String get(String key, int timestamp) {
    //         if (!map.containsKey(key)) return "";
            
    //         TreeMap<Integer, String> tree = map.get(key);
    //         Integer t = tree.floorKey(timestamp);  // largest key <= timestamp
            
    //         if (t == null) return "";
    //         return tree.get(t);
    //     }
    private static class Entry {
        int time;
        String val;
        Entry(int time, String val) {
            this.time = time;
            this.val = val;
        }
    }

    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> list = map.get(key);
        if (list == null) return "";

        // Find rightmost entry with time <= timestamp
        int left = 0, right = list.size() - 1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= timestamp) {
                ans = list.get(mid).val;
                left = mid + 1;        // move right to find later valid time
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */