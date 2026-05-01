class Solution {
    public int[] plusOne(int[] digits) {
        
       
        int n = digits.length;
        ArrayList<Integer> list = new ArrayList<>();

        int carry =0;
        int lastDigit = 0;
         lastDigit = digits[n-1]+1;
        if(lastDigit>=10){
            carry = 1;
        }
        list.add(lastDigit%10);
        
        for(int i=n-2;i>=0;i--){
            list.add(digits[i]+carry);
        }

        Collections.reverse(list);

        int[] result = new int[list.size()];

       for (int i = 0; i < list.size(); i++) {
    result[i]=list.get(i);
}

        return result;
    }
}
