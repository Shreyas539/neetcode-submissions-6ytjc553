class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder s = new StringBuilder();

        for(int i:digits){
            s.append(i);
        }

        int res = Integer.parseInt(s.toString());
        res+=1;

        List<Integer> list = new ArrayList<>();

        while(res!=0){
            int num = res%10;
            list.add(num);
            res=res/10;
        }

        Collections.reverse(list);

        int[] result = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
    result[i] = list.get(i);
}


        System.out.println(res);

        return result;
    }
}
