class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // 1. filter out all the triples that triple[i] > target [i]
        // 2. for all the target[i], must be at least one triple[i]==target[i]
        int[] res = new int[3];

        for(int[] triple: triplets){
            // 1. filter out
            if(triple[0] > target[0] || triple[1] > target[1] || triple[2] > target[2]) continue;
            // 2. match 3 elements
            if(triple[0] == target[0]) res[0]=1;
            if(triple[1] == target[1]) res[1]=1;
            if(triple[2] == target[2]) res[2]=1;
        }
        return res[0]+res[1]+res[2]==3;
        
    }
}