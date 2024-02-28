class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // we use the smallest cookie and assign it to the right child;
        // then one by one;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int res = 0;
            while(i < s.length && j < g.length){
                if(s[i] < g[j]) i++;
                else {res++; i++; j++;}
                
            }
        return res;
        
    }
}