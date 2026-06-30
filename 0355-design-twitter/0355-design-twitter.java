class Twitter {
    private int time;
    private Map<Integer,Set<Integer>> followMap;
    private Map<Integer,List<Tweet>> tweetMap;

     private class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new ArrayList<>();
        
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        
        // max-haep for time stamp
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // Add latest tweet from each followee
        for (int followee : followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                List<Tweet> tweets = tweetMap.get(followee);
                int lastIndex = tweets.size() - 1;
                if (lastIndex >= 0) {
                    Tweet t = tweets.get(lastIndex);
                    // [time, tweetId, userId, index]
                    maxHeap.add(new int[]{t.time, t.id, followee, lastIndex});
                }
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] top = maxHeap.poll();

            result.add(top[1]); // tweetId

            int followee = top[2];
            int index = top[3] - 1; // move to older tweet

            if (index >= 0) {
                Tweet nextTweet = tweetMap.get(followee).get(index);
                maxHeap.add(new int[]{
                    nextTweet.time,
                    nextTweet.id,
                    followee,
                    index
                });
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */