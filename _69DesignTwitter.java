package com.datastructures_algorithms.neetcode_150._3_25;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/
 */
public class _69DesignTwitter {
    private static class Tweet {
        int time;
        int tweetId;
        Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    private final Map<Integer, Set<Integer>> follows;
    private final Map<Integer, List<Tweet>> tweets;
    private int time;

    public _69DesignTwitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        follows.computeIfAbsent(userId, k -> {
            HashSet<Integer> set = new HashSet<>();
            set.add(userId);
            return set;
        });

        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new Tweet(time++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>(List.of(userId)));

        class Entry {
            int time;
            int tweetId;
            int userId;
            int idx;
            Entry(int time, int tweetId, int userId, int idx) {
                this.time = time; this.tweetId = tweetId; this.userId = userId; this.idx = idx;
            }
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        for (int followee : followees) {
            List<Tweet> list = tweets.get(followee);
            if (list != null && !list.isEmpty()) {
                int idx = list.size() - 1;
                Tweet t = list.get(idx);
                pq.offer(new Entry(t.time, t.tweetId, followee, idx));
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            Entry e = pq.poll();
            result.add(e.tweetId);

            int nextIdx = e.idx - 1;
            if (nextIdx >= 0) {
                Tweet nextTweet = tweets.get(e.userId).get(nextIdx);
                pq.offer(new Entry(nextTweet.time, nextTweet.tweetId, e.userId, nextIdx));
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> {
            HashSet<Integer> set = new HashSet<>();
            set.add(followerId);
            return set;
        });
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        Set<Integer> set = follows.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }
}
