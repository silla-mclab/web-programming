package com.example.test09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		
		ServletContext context = sce.getServletContext();
		
		Properties pInfoTable 
			= (Properties)context.getAttribute("pinfo_table");
		
		String fileName = context.getInitParameter("db_file");
		
		try {
			OutputStream os = new FileOutputStream(fileName);
			pInfoTable.store(os, null);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		// get file-name from context init-parameter
		ServletContext context = sce.getServletContext();
		String fileName = context.getInitParameter("db_file");
		
		// create & load properties object from db file
		Properties pInfoTable = new Properties();
		
		try {
			InputStream is = new FileInputStream(fileName);
			pInfoTable.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// bind properties object to context attribute table
		context.setAttribute("pinfo_table", pInfoTable);
	}

}
