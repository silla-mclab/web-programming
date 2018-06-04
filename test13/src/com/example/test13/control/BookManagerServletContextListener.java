package com.example.test13.control;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.test13.model.DBConnectionInfo;

public class BookManagerServletContextListener 
		implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		ServletContext context = sce.getServletContext();

		DBConnectionInfo connInfo = new DBConnectionInfo();
		connInfo.setJdbcDriver(
				context.getInitParameter("mysql-jdbc-driver"));
		connInfo.setDbUrl(
				context.getInitParameter("db-url"));
		connInfo.setDbUser(
				context.getInitParameter("db-user"));
		connInfo.setDbPassword(
				context.getInitParameter("db-password"));
		connInfo.setDbTable(
				context.getInitParameter("db-table"));
		
		context.setAttribute("connection-info", connInfo);	
	}

}
