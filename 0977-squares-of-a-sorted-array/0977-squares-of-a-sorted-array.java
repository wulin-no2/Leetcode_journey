class Solution {
    public int[] sortedSquares(int[] nums) {
        // Approach 2 - 2 pointers from 2 end to center;
        Deque<Integer> list = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left]*nums[left] >= nums[right]*nums[right]){
                list.addFirst(nums[left]*nums[left]);
                left++;
            }
            else{
                list.addFirst(nums[right]*nums[right]);
                right--;
            }
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = list.removeFirst();
        }
        return result; 
        
        // Approach 1 - brute force.square, then sort. O(nlogn);
        /*
        for(int i = 0 ; i < nums.length ; i ++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
        */
    }
}