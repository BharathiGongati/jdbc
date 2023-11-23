package org.jsp.uiApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet
{
    @Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
    	//Fetch ui form data
    	String Name=req.getParameter("nm");
    	String Place=req.getParameter("pl");
    	
    	//Presentation logic
    	PrintWriter out=resp.getWriter();
    	out.println("<html><body bgcolor='orange'>"
    			+"<h1>Student name is "+Name+" from "+Place+"</h1>"
    			+"</body></html>");
    	out.close();
    	
		
	}
}
