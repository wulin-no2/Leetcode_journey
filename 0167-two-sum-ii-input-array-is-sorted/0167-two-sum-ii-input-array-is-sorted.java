class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 2 pointers
        int p1 = 0;
        int p2 = numbers.length - 1;
        while(p1 < p2){
            if(numbers[p1] + numbers[p2] == target) return new int[]{p1 + 1, p2 + 1};
            else if(numbers[p1] + numbers[p2] < target){
                p1++;
            }else{
                p2--;
            } 
        }
        // remember to increment by one
        return new int[2];
    }
}