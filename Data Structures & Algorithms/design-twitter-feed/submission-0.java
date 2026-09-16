class Twitter{
    static class Tweet{
        int id;
        int time;

        Tweet(int id,int time){
            this.id=id;
            this.time=time;
        }
    }

    static class Node{
        int userId;
        int index;

        Node(int userId,int index){
            this.userId=userId;
            this.index=index;
        }
    }

    Map<Integer,List<Tweet>> tweets;
    Map<Integer,Set<Integer>> following;
    int time;

    public Twitter(){
        tweets=new HashMap<>();
        following=new HashMap<>();
        time=0;
    }

    public void postTweet(int userId,int tweetId){
        tweets.computeIfAbsent(userId,k->new ArrayList<>())
              .add(new Tweet(tweetId,time++));
    }

    public List<Integer> getNewsFeed(int userId){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->
            Integer.compare(
                tweets.get(b.userId).get(b.index).time,
                tweets.get(a.userId).get(a.index).time
            )
        );

        Set<Integer> users=new HashSet<>();
        users.add(userId);
        users.addAll(following.getOrDefault(userId,new HashSet<>()));

        for(int user:users){
            if(tweets.containsKey(user)){
                List<Tweet> list=tweets.get(user);
                pq.offer(new Node(user,list.size()-1));
            }
        }

        List<Integer> ans=new ArrayList<>();

        while(!pq.isEmpty()&&ans.size()<10){
            Node cur=pq.poll();
            Tweet tweet=tweets.get(cur.userId).get(cur.index);
            ans.add(tweet.id);

            if(cur.index>0)
                pq.offer(new Node(cur.userId,cur.index-1));
        }

        return ans;
    }

    public void follow(int followerId,int followeeId){
        following.computeIfAbsent(followerId,k->new HashSet<>())
                 .add(followeeId);
    }

    public void unfollow(int followerId,int followeeId){
        following.getOrDefault(followerId,new HashSet<>())
                 .remove(followeeId);
    }
}