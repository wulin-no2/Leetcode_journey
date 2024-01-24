class Solution {
    public int[] sortedSquares(int[] nums) {
        // Approach 2 - how to make O(n)? Use priority Queue, convert it to array?
        /*PriorityQueue<Integer> pq = new PriorityQueue<>(a,b -> a - b);
        for(int i = 0 ; i < nums.length ; i ++){
            nums[i] = nums[i] * nums[i];
            
        }
        */
        
        // Approach 3 - 2 pointers from 2 end to center;
        Deque<Integer> list = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;
        System.out.println(" left: "+left + " right: " + right);
        while(left <= right){
            if(nums[left]*nums[left] >= nums[right]*nums[right]){
                list.addFirst(nums[left]*nums[left]);
                left++;
                System.out.println(" left: "+left + " right: " + right);
            }

            else{
                list.addFirst(nums[right]*nums[right]);
                right--;
                System.out.println(" left: "+left + " right: " + right);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = list.removeFirst();
            System.out.println(" result[]"+ i+ "] " + result[i]);
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