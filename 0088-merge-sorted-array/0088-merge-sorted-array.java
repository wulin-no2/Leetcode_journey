class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // analyze(17:45-17:51 20231106):
        // new Queue q
        // two indexes mp=0 np=0
        // 1) compare num1[mp] and num2[np], push the smaller one into queue, set p++
        // 2) repeat the loop until mp == m-1 && np == n-1
        // 3) pool the elements of queue to nums1 until queue is empty.
        // the time complexity is O(m+n)
        Queue<Integer> q = new LinkedList<>();

        int mp = 0;
        int np = 0;
        //if n == 0, do nothing; if m == 0 copy nums2 to nums1:
        if(m == 0 && n!= 0){
            while(np < n){
                nums1[mp] = nums2[np];
                mp++;
                np++;
            }
        }
        while(m != 0 && n != 0 && mp < m && np < n){
            if(nums1[mp] <= nums2[np]){
                q.offer(nums1[mp]);
                mp ++;
            }else{
                q.offer(nums2[np]);
                np ++;  
            }
        }
        while(mp < m){
            q.offer(nums1[mp]);
            mp ++;
        }
        while(np < n){
            q.offer(nums2[np]);
            np ++;
        }

        // pool the elements in queue out:
        int i = 0;
        while(!q.isEmpty() && i < m + n){
            nums1[i] = (int)q.poll();
            i++;
        } 
    }
    // submit the last version at 18:45 20231106; 1h;
}