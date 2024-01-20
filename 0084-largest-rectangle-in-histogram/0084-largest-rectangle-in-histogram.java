class Solution {
    public int largestRectangleArea(int[] heights) {
          int area = 0, n = heights.length;
          int start;
        // Pair holds index and the height of the bar
          Stack<Pair<Integer,Integer>> stack = new Stack<>();
        // traverse from 0 to end; of the histogram;
          for(int i = 0; i < heights.length; i ++){
             int curHt =heights[i];
              // start is the pointer
             start = i;
              // see if the last height > curHt. if so, pop it; else, push it;
            while(!stack.isEmpty() && stack.peek().getValue() > curHt){
              Pair<Integer,Integer> pair = stack.pop();
              int index = pair.getKey();
              int h = pair.getValue();
                // update max area;
              area = Math.max(area, h * (i - index));
                // update index;
              start = index;
            }
            stack.push(new Pair(start,curHt));
          }
        // after traversing, get max area and ramaming bars in the stack;
        // go on pop() and update;
           while(!stack.isEmpty()){
              Pair<Integer,Integer> pair = stack.pop();
              int index = pair.getKey();
              int h = pair.getValue();
              area = Math.max(area, h * (n - index));
           }
            return area;
    }
}