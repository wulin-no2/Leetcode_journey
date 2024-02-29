class Solution {
    public int candy(int[] ratings) {
        // we go 3 pass;
        // 1) 1st pass: give everyone 1 candy;
        // 2) 2nd pass: from start to end, check if next one is bigger or smaller than this, and see it we should add candy to this;
        // 3) 3rd pass: from end to start;
        int res = 0;
        int[] candy = new int[ratings.length];
        // 1st pass:
        for(int i = 0; i < ratings.length ; i++){
            candy[i] = 1;
            res++;
        }
        // 2nd pass:
        for(int i = 0; i < ratings.length - 1 ; i++){
            while(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {candy[i]++;res++;}
            while(ratings[i] < ratings[i + 1] && candy[i] >= candy[i + 1]) {candy[i+1]++;res++;}
        }
        // 3rd pass:
        for(int i = ratings.length - 1; i >= 1 ; i--){
            while(ratings[i] > ratings[i - 1] && candy[i] <= candy[i - 1]) {candy[i]++;res++;}
            while(ratings[i] < ratings[i - 1] && candy[i] >= candy[i - 1]) {candy[i-1]++;res++;}
        }
        return res;
        
        
    }
}