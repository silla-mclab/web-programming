package com.example.test15;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyHeader extends SimpleTagSupport {
	private String fontColor = "#00000";
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<img src='/test15/webservice.jpg' width='320' height='320'/><br>");
		out.print("<h3><em><font color='" + fontColor +"'>");
		getJspBody().invoke(null);
		out.print("</font></em></h3>");		
	}
	
	public void setFontColor(String color) {
		this.fontColor = color;
	}

}
