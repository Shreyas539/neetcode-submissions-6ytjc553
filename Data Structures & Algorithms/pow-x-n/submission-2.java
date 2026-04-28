class Solution {
    public double myPow(double x, int n) {
        double res = x;
        int temp = n;

        if(n==0){
            return 1.00000;
        }
        if(n>0){
            n--;
            while(n!=0){
                res *=x;
                n--;
            }
        }else{
            n++;
            while(n!=0){
                res *=x;
                n++;
            }
        }

        if(temp<0){
            return 1/res;
        }

        return res;
    }
}
