class Solution {
    public int candy(int[] ratings) {
        // we go 3 pass;
        // 1) 1st pass: give everyone 1 candy;
        // 2) 2nd pass: from start to end, check if next one is bigger or smaller than this, and see it we should add candy to this;
        // 3) 3rd pass: from end to start;
        /*
        int res = 0;
        int[] candy = new int[ratings.length];
        // 1st pass:
        for(int i = 0; i < ratings.length ; i++){
            candy[i] = 1;
            res++;
        }
        // 2nd pass:
        for(int i = 0; i < ratings.length - 1 ; i++){
            if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {int temp = candy[i]; candy[i] = candy[i + 1] + 1;res += candy[i] - temp;}
            if(ratings[i] < ratings[i + 1] && candy[i] >= candy[i + 1]) {int temp = candy[i+1]; candy[i + 1] = candy[i] + 1;res += candy[i + 1] - temp;}
        }
        // 3rd pass:
        for(int i = ratings.length - 1; i >= 1 ; i--){
            if(ratings[i] > ratings[i - 1] && candy[i] <= candy[i - 1]) {int temp = candy[i]; candy[i] = candy[i - 1] + 1;res += candy[i] - temp;}
            if(ratings[i] < ratings[i - 1] && candy[i] >= candy[i - 1]) {int temp = candy[i-1]; candy[i - 1] = candy[i] + 1;res += candy[i - 1] - temp;}
        }
        return res;
        */
        // another 1pass approach from discuss, don't understand:
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;

    }
}