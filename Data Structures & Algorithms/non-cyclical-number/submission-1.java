class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(n!=1){
            n = helper(n);
            if(n==1){
                return true;
            }
            if(set.contains(n)){
                return false;
            }else{
                set.add(n);
            }
        }

        return true;
    }

    private int helper(int num){
        int sum=0;

       while(num!=0){
            int digit = num%10;
            sum += Math.pow(digit,2);
            num=num/10;
        }

        return sum;
    }
}
