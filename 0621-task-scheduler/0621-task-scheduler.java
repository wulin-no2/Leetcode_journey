class Solution {
    public int leastInterval(char[] tasks, int n) {
        // analyze: find the most task, put it every n; 
        // then put the 2nd most task after each first task;
        if (n == 0) return tasks.length;
        // here is a comparator implemented in lambda expression:
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] arr = new int[26];
        // find the frequency of each letter;
        for (char c : tasks) arr[c - 'A']++;
        // if frequency > 0,add to pq;
        for (int val : arr) if (val > 0) pq.add(val);
        int time = 0;
        // start running:
        while ((!pq.isEmpty() || !q.isEmpty())) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) q.add(new Pair(val, time + n));
            }

            if (!q.isEmpty() && q.peek().getValue() == time) pq.add(
                q.poll().getKey()
            );
        }
        return time;
    }
}