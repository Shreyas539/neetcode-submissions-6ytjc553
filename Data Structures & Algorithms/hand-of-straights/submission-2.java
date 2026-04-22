class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand);
        int prev= hand[0];

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        while(!map.isEmpty()){
            int first = map.firstKey();

            for(int v = first;v<first+groupSize;v++){
                Integer c = map.get(v);

                if(c==null){
                    return false;
                }

                if(c==1){
                    map.remove(v);
                }else{
                    map.put(v,c-1);
                }
            }
        }

        return true;
        
    }
}
