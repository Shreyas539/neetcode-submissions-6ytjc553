
class Tweet {
    int id;
    int time;

    Tweet(int id,int time){
        this.id = id;
        this.time = time;
    }
}
class Twitter {
    private int time;
    private Map<Integer,List<Tweet>> tweetmap;
    private Map<Integer,Set<Integer>> followmap;

    public Twitter() {
        time =0 ;
        tweetmap = new HashMap<>();
        followmap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetmap.putIfAbsent(userId,new ArrayList<>());
        tweetmap.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);

        if(tweetmap.containsKey(userId)){
            pq.addAll(tweetmap.get(userId));
        }

        if(followmap.containsKey(userId)){
            for(int followee:followmap.get(userId)){
                if(tweetmap.containsKey(followee)){
                    pq.addAll(tweetmap.get(followee));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int cnt=0;

        while(!pq.isEmpty() && cnt<10){
            res.add(pq.poll().id);
            cnt++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        followmap.putIfAbsent(followerId,new HashSet<>());
        followmap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followmap.containsKey(followerId)){
            followmap.get(followerId).remove(followeeId);
        }
    }
}
