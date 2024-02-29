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
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int i = 0;
        int s = 0; //record the start index of the left and right sides of the peaks
        int sum = 1; //initialize as 1 because in each round we minus 1 for the left bottom 
                   //since it was calculated once in the previous round
        while(i < n-1){
            //calculate the length from bottom -> peak on the left side of peak point, peak not included
            while(i < n-1 && ratings[i+1] > ratings[i]){
                i++;
            }
            int left = i-s;
            s = i;
            //calculate the length from peak-> bottom on the right side of peak point, peak not included
            while(i < n-1 && ratings[i+1] < ratings[i]){
                i++;
            }
            int right = i-s;
            s = i;
            //calculate the candies that needs to be assign to the peak
            int max = Math.max(left, right)+1;
            //total candies needed for current bottom->peak->bottom sub array
            sum += (1+left)*left/2+(1+right)*right/2+max-1;
            //skip points that have same value, increase i and final result by 1
            while(i < n-1 && ratings[i+1] == ratings[i]){
                i++;
                sum++;
            }
            s = i;
        }
        
        return sum;
    }
}