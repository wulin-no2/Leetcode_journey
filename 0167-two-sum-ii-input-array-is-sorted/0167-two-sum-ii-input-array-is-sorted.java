class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 2pointers
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target) return new int[]{left+1, right+1};
            while(left < right && (numbers[left] + numbers[right] > target)){
                right--;
            }
            while(left < right && (numbers[left] + numbers[right] < target)){
                left++;
            }
        }
        return null;
        
    }
}