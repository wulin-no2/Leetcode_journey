class Solution {
    public boolean lemonadeChange(int[] bills) {
        //use map to trace money we have;
        /*
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        for(int i : bills){
            if(i == 5){
                map.put(5, map.get(5) + 1);
            }
            else if(i == 10){
                if(map.get(5) <= 0) return false;
                else {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) + 1);
                }
                    
            }
            else{
                if(map.get(5) >= 1 && map.get(10) >= 1) {
                    map.put(5, map.get(5)-1);
                    map.put(10, map.get(10)-1);
                }
                else if(map.get(10) <= 0 && map.get(5) >= 3){
                    map.put(5, map.get(5)-3);
                }
                else return false;
            }
        }  
        return true;
        */
        // now use 2 int to trace;
        int five = 0;
        int ten = 0;
        for(int i : bills){
            if(i == 5) five++;
            else if(i == 10){
                if(five <= 0) return false;
                else {five--;ten++;}
            }
            else{
                if(five >= 1 && ten >= 1) {five--;ten--;}
                else if(ten <= 0 && five >= 3) five -= 3;
                else return false;
            }
        }  
        return true;
    }
}