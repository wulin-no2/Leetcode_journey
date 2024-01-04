class Solution {
    public int[] productExceptSelf(int[] nums) {
        // analyze1:
        // int newArray[n];
        // newArray[i] = preProduct[i] * sufProduct[i];
        // preProduct[i] = preProduct[i-1] * nums[i-1];
        // sufProduct[i] = sufProduct[i+1] * nums[i+1];
        // we can use several for loops to solve this problem:
        int n = nums.length;
        int[] newArray = new int[n];
        int[] preProduct = new int[n];
        int[] sufProduct = new int[n];
        for(int i = 0; i < n; i++){
            newArray[i] = 1;
        }
        preProduct[0] = 1;
        for(int i = 1; i < n; i++){
            preProduct[i] = preProduct[i-1] * nums[i-1];
        }
        sufProduct[n-1] = 1;
        for(int i = n - 2; i >= 0; i--){
            sufProduct[i] = sufProduct[i+1] * nums[i+1];
        }
        for(int i = 0; i < n; i++){
            newArray[i] = preProduct[i] * sufProduct[i]; 
        }
        return newArray;
            
    }
}