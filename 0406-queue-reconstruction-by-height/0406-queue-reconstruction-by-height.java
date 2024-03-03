class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people by height in descending order; if heights are equal, sort by the second value in ascending order
        //Arrays.sort(people, (a, b) -> Integer.compare(b[0], a[0])); 
        Arrays.sort(people, (a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1]; // Ascending order for the second value if heights are the same
        return b[0] - a[0]; // Descending order for height
    });
        LinkedList<int[]> q = new LinkedList<>();
//         for (int i = 0; i < people.length; i++) {
//             // Add each person by their "k" value, which is the index in the queue
//             q.add(people[i][1], people[i]);
//         }
        
        for (int[] p : people) {
            q.add(p[1],p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }
        return q.toArray(new int[people.length][]);

    }
}