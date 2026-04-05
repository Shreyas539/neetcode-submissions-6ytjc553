class TimeMap {

    private HashMap<String,List<Pair>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key,new ArrayList<>());
        mp.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int tgts) {
        if(!mp.containsKey(key)) return "";

        List<Pair> lst = mp.get(key);
        int l=0,r=lst.size()-1;
        String res="";
        while(l<=r){
            int mid = l+(r-l)/2;
            if(lst.get(mid).ts<=tgts){
                res = lst.get(mid).value;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}

class Pair{
    String value;
    int ts ;

    Pair(String value,int ts){
        this.value = value;
        this.ts = ts;
    }
}
