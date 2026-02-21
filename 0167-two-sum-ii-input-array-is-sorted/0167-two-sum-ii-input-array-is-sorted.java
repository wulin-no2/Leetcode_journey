class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // two pointers, move inward
        int p1 = 0;
        int p2 = numbers.length - 1;
        for(int i = 0; i < numbers.length - 1; i++){
            // compare
            if(numbers[p1] + numbers[p2] == target) return new int[]{p1 + 1, p2 + 1};
            while(numbers[p1] + numbers[p2] > target) p2--;
            while(numbers[p1] + numbers[p2] < target) p1++;
        }
        return null;

        
    }
}