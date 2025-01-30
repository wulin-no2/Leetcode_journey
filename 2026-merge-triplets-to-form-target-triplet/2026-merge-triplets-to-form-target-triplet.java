class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // 1. filter out triplet if any ith element bigger than target[i]
        // 2. check if there are ith element = target[i] for all the elements in target
        int[] res = new int[3];
        for(int[] triplet: triplets){
            // 1. filter out
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            // 2. check each element
            if(triplet[0] == target[0]) res[0] = 1;
            if(triplet[1] == target[1]) res[1] = 1;
            if(triplet[2] == target[2]) res[2] = 1;
        }
        return res[0]+res[1]+res[2]==3;

        
    }
}