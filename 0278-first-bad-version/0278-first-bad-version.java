/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // use binary search.
        // each time check the middle one;
        // if it's true,maybe there will older versions true.
        // find the true 1, then the left one must be false;
        
        // we numst use minimize numbers of API
        /*
        int low = 1;
        int high = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){
                if(mid == 1 || ! isBadVersion(mid - 1)){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else{
                low = mid + 1;
            }
        }
        return n;
        */
        
        // there is a faster approach in discuss:
        int i = 1;
        int j = n;

        while (i < j) {

            int mid = i + (j - i) / 2;

            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }

        }

        return i;
    }
}