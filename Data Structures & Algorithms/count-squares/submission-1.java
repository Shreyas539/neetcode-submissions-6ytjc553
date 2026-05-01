class CountSquares {

    Map<String,Integer> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        // int x = point[0]
        String key = point[0]+","+point[1];
        map.put(key,map.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        
        int x = point[0],y=point[1];
        int cnt = 0;
        for(String key:map.keySet()){
            String[] parts = key.split(",");
            int xi = Integer.parseInt(parts[0]);
            int yi = Integer.parseInt(parts[1]);

            if(Math.abs(xi-x)!=Math.abs(yi-y) || xi==x || yi==y){
                continue;
            }

            String corner1 = xi+","+y;
            String corner2 = x+","+yi;

            if(map.containsKey(corner1) && map.containsKey(corner2)){
                int freqDiagonal = map.get(key);
                int freqCorner1 = map.get(corner1);
                int freqCorner2 = map.get(corner2);

                cnt=freqDiagonal*freqCorner1*freqCorner2;
            }


        }

        return cnt;
    }
}
