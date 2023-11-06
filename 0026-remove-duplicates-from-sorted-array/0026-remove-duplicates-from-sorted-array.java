class Solution {
    public int removeDuplicates(int[] nums) {

        //analyze:
        // we need a data structure that is FIFO and in which the last element can be retrieved to compare.
        //A deque is suitable for this problem.
        
        // create a deque.
        // offerLast() the first element of the array.
        // compare the last element getLast() with the next element of the array. if it's the same, move to next element of the array;if not, offerLast;
        // loop array.length - 1.
        // pollFirst of the deque and assign to the array from beginning.
        
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(nums[0]);
        //compare and add or move:
        int p = 1;
        while(p < nums.length){
            if(q.getLast() != nums[p]){
                q.offerLast(nums[p]);
            }
            p++;
        }
        // poll all the elements of the deque:
        int i = 0;
        while(!q.isEmpty()){
            nums[i] = q.pollFirst();
            i++;
        }
        return i;
    }
}