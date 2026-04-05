class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for(int num:piles){
            maxSpeed = Math.max(maxSpeed,num);
        }

        int left = 1;
        int right = maxSpeed;

        while(left<right){
            int mid = left + (right-left)/2;

            if(canIEatAllWithThisSpeed(mid,h,piles)){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;

    }

    private boolean canIEatAllWithThisSpeed(int speed,int h,int[] piles){
        int totHoursAtThisSpeed = 0;
        for(int num:piles){
            totHoursAtThisSpeed+=(int)Math.ceil((double)num/speed);
        }
        return totHoursAtThisSpeed <=h;
    }
}
