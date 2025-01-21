class Twitter {

    // Global timestamp for tweet sorting
    private int timestamp;

    // Map: userId -> set of followees
    private Map<Integer, Set<Integer>> followingMap;

    // Map: userId -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    // Inner class to represent a Tweet
    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // Constructor
    public Twitter() {
        timestamp = 0;
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // Post a tweet
    public void postTweet(int userId, int tweetId) {
        // Create the tweet
        Tweet tweet = new Tweet(tweetId, timestamp++);
        // Add to the user's tweet list
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(tweet);
    }

    // Retrieve the 10 most recent tweet IDs in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        // PriorityQueue to keep track of 10 most recent tweets
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        // Add the user's own tweets
        if (tweetMap.containsKey(userId)) {
            for (Tweet tweet : tweetMap.get(userId)) {
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        // Add tweets from followees
        if (followingMap.containsKey(userId)) {
            for (int followeeId : followingMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    for (Tweet tweet : tweetMap.get(followeeId)) {
                        pq.offer(tweet);
                        if (pq.size() > 10) {
                            pq.poll();
                        }
                    }
                }
            }
        }

        // Extract tweets from PriorityQueue
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().id);
        }
        Collections.reverse(result); // Reverse to get tweets in descending order of time
        return result;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot follow themselves
        followingMap.putIfAbsent(followerId, new HashSet<>());
        followingMap.get(followerId).add(followeeId);
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot unfollow themselves
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
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