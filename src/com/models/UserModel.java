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
public class UserModel {
Cluster cluster;

public UserModel(){

}

public void setCluster(Cluster cluster){
this.cluster=cluster;
}

public void addUser(String user, String password, String email)
{
	Session session = cluster.connect("keyspace2");
	PreparedStatement statement = session.prepare("insert into Users (user, password, email) values ('"+ user+ "','"+ password +"','" + email + "');");	
	BoundStatement boundStatement = new BoundStatement(statement);
	session.execute(boundStatement);
	//ResultSet rs = session.execute(boundStatement);
	session.close();
}

public int Check(String user, String password)
{
	String checkpassword="";
	
	Session session = cluster.connect("keyspace2");
	PreparedStatement statement = session.prepare("select * from Users where user = '"+ user +"';");	
	BoundStatement boundStatement = new BoundStatement(statement);
	ResultSet rs = session.execute(boundStatement);
	if (rs.isExhausted()) 
	{
		System.out.println("No such user");
	} 
	else 
	{		
		for (Row row : rs) {
			checkpassword = row.getString("password");
		}
		

    	System.out.println(checkpassword);
    	System.out.println(password);
		if (password.endsWith(checkpassword))
		{		
			System.out.println("login sucsessed");
			session.close();
			return 1;
		}
		else
			System.out.println("incorrect login or password");
	}
		
	
	
	
	
	
	session.close();
	return 0;
}


}