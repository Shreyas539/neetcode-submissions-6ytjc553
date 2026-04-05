class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[t.length];

        for(int i=0;i<t.length;i++){
            while(!s.isEmpty() && t[i]>t[s.peek()]){
                int prevIdx = s.pop();
                res[prevIdx] = i - prevIdx;
            }
            s.push(i);
        }
        return res;
    }
}
