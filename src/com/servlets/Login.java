package com.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastax.driver.core.Cluster;
import com.lib.CassandraHosts;
import com.models.TweetModel;
import com.models.UserModel;
import com.servlets.Tweet;
import com.stores.TweetStore;

@WebServlet({ "/Login", "/Login/*" })
public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;
    private Cluster cluster;
    /**
* @see HttpServlet#HttpServlet()
*/
    public Login() {
        super();
        // TODO Auto-generated constructor stub

    }
    public void init(ServletConfig config) throws ServletException {
// TODO Auto-generated method stub
cluster = CassandraHosts.getCluster();
}
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    	String user = request.getParameter("username");
		    	String password = request.getParameter("password");
		    	String email = request.getParameter("email");
		    	UserModel tm= new UserModel();
		    	tm.setCluster(cluster);	
		    	System.out.println(user);
		    	System.out.println(password);
		    	System.out.println(email);
		    	tm.addUser(user, password, email);
		    	//Tweet.doGet(request, response);
		    	RequestDispatcher rd = request.getRequestDispatcher("/Tweet.jsp");
		    	rd.forward(request, response);
		}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//String args[]=Convertors.SplitRequestPath(request);
		RequestDispatcher rd;
		
		
		if (request.getParameter("username1")!=null)
		{
			String username = request.getParameter("username1");
			String password=request.getParameter("password1");
			
			System.out.println(username);
			System.out.println(password);
			
			UserModel tm= new UserModel();
			tm.setCluster(cluster);
			
			if (tm.Check(username, password)==1)
			{
				request.setAttribute("Username", username);
				rd = request.getRequestDispatcher("/LoginSucessed.jsp");
				rd.forward(request, response);
			}
			else
			{
				rd = request.getRequestDispatcher("/Login.jsp");    
				rd.forward(request, response);	
			}
		}
		else
		{
			rd = request.getRequestDispatcher("/Login.jsp");    
			rd.forward(request, response);				
		}
		
		
	}
  
}
