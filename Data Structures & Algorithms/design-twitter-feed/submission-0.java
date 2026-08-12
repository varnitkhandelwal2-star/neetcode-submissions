class Twitter {
    HashMap<Integer, Set<Integer>> follows = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    int timestamp = 0 ;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
       tweets.computeIfAbsent(userId, k -> new ArrayList<>())
       .add(new int[]{timestamp++, tweetId});

    }
    
    public List<Integer> getNewsFeed(int userId) {
                // min heap by timestamp
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]  // sort by timestamp ascending
        );
     Set<Integer> allUsers = new HashSet<>();

        // add userId itself to check his own tweets too!
        allUsers.add(userId);
        allUsers.addAll(follows.getOrDefault(userId, new HashSet<>())); 
        
    for(int user : allUsers) {  
        for(int[] tweet : tweets.getOrDefault(user, new ArrayList<>())) {
        pq.offer(tweet);
        if(pq.size() > 10) pq.poll(); // ← remove oldest if size > 10
    }
}
        // build result
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll()[1]); // [1] is tweetId
        }
        Collections.reverse(result);
        return result ;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>())
       .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>())  
        .remove(followeeId) ;
    }
}
