class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people by height in descending order; if heights are equal, sort by the second value in ascending order
        Arrays.sort(people, (a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1]; // Ascending order for the second value if heights are the same
        return b[0] - a[0]; // Descending order for height
    });
        LinkedList<int[]> q = new LinkedList<>();
        for (int[] p : people) {
            q.add(p[1],p);   //Linkedlist.add(index, value)
        }
        return q.toArray(new int[people.length][]);
    }
}