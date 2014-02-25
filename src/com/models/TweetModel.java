package com.models;

/*
* Expects a cassandra columnfamily defined as
* use keyspace2;
CREATE TABLE Tweets (
user varchar,
interaction_time timeuuid,
tweet varchar,
PRIMARY KEY (user,interaction_time)
) WITH CLUSTERING ORDER BY (interaction_time DESC);
* To manually generate a UUID use:
* http://www.famkruithof.net/uuid/uuidgen
*/


import java.util.LinkedList;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import com.lib.*;
import com.stores.TweetStore;
public class TweetModel {
Cluster cluster;
public TweetModel(){

}

public void setCluster(Cluster cluster){
this.cluster=cluster;
}

public void addTweet(String NewTweet, String username)
{
	Session session = cluster.connect("keyspace2");
	PreparedStatement statement = session.prepare("insert into Tweets (user, interaction_time, tweet) values ('"+ username +"', now(),'" + NewTweet + "');");	
	BoundStatement boundStatement = new BoundStatement(statement);
	session.execute(boundStatement);
	//ResultSet rs = session.execute(boundStatement);
	session.close();
}

public LinkedList<TweetStore> getTweets(String username) {
LinkedList<TweetStore> tweetList = new LinkedList<TweetStore>();
Session session = cluster.connect("keyspace2");

PreparedStatement statement = session.prepare("SELECT * from tweets;");
BoundStatement boundStatement = new BoundStatement(statement);
ResultSet rs = session.execute(boundStatement);
if (rs.isExhausted()) {
System.out.println("No Tweets returned");
} else {
{
for (Row row : rs) {
if( row.getString("user").equals(username) )
{
	TweetStore ts = new TweetStore();
	ts.setTweet(row.getString("tweet"));
	ts.setUser(row.getString("user"));
	tweetList.add(ts);
}
}
}
}
session.close();
return tweetList;
}
}


