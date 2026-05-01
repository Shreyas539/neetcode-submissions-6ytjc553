class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> mp = new HashMap<>();

        for(List<String> t:tickets){
            String src = t.get(0) , dst = t.get(1);
            mp.computeIfAbsent(src,k-> new ArrayList<>()).add(dst);
        }

        for(String src:mp.keySet()){
            Collections.sort(mp.get(src));
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");

        if(dfs("JFK",mp,res,tickets.size())){
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs(String src,Map<String,List<String>> mp,List<String> res,int n){
        if(res.size()==n+1){
            return true;
        }


        List<String> nbrs = new ArrayList<>(mp.get(src));

        for(int i=0;i<nbrs.size();i++){
            String v = nbrs.get(i);
            mp.get(src).remove(i);

            res.add(v);

            if(dfs(v,mp,res,n)){
                return true;
            }
            mp.get(src).add(i,v);
            res.remove(res.size()-1);
        }

        return false;
    }
}
