class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand);
        int prev= hand[0];

        int size=0;
        for(int i=1;i<n;i++){
            if(prev+1 == hand[i]){
                prev = hand[i];
                size++;
            }
        }
        System.out.println("size="+size);
        return size==groupSize ? true : false;
    }
}
