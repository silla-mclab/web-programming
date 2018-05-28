package com.example.test13.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDbDao {
	private final String mysql_jdbc_driver = "com.mysql.jdbc.Driver";
	private final String db_url = "jdbc:mysql://localhost:3306/bookdb1"
					+"?serverTimezone=Asia/Seoul&useSSL=false";
	private final String db_user = "testuser";
	private final String db_passwd = "test1234";
	private final String db_table = "bookinfo";
	
	private Connection dbConn = null;
	
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(mysql_jdbc_driver);
		dbConn = DriverManager.getConnection(
				db_url, db_user, db_passwd);			
	}
	
	public void disconnect() throws SQLException {
		if (dbConn != null) {
			dbConn.close();
		}
	}
	
	public ArrayList<BookDto> getBookList(String code) 
			throws SQLException, ClassNotFoundException {
		ArrayList<BookDto> bookList = null;
		
		connect();
		
		Statement stmt = dbConn.createStatement();
		
		String sql = "select * from " + db_table;
		if (code == null || code.length() == 0) {
			sql += ";";
		}
		else {
			sql += " where code = " + code + ";";
		}
		
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs.isBeforeFirst()) {
			bookList = new ArrayList<BookDto>();
			
			while (rs.next()) {
				BookDto book = new BookDto();
				book.setCode(rs.getString("code"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setPrice(rs.getInt("price"));
				
				bookList.add(book);		
			}
		}
		
		rs.close();
		stmt.close();
		
		disconnect();
	
		return bookList;
	}
	
	public int insertBook(BookDto book) throws ClassNotFoundException, SQLException {
		int result = 0;	
		if (book == null)  return 0;
		
		connect();
		
		Statement stmt = dbConn.createStatement();
		
		String sql = "insert into " + db_table 
				+ " (code, title, writer, price) values (";
		sql += "'" + book.getCode() +"', ";
		sql += "'" + book.getTitle() +"', ";
		sql += "'" + book.getWriter() +"', ";
		sql += book.getPrice() +");";
		
		result = stmt.executeUpdate(sql);
		
		stmt.close();
		
		disconnect();
		
		return result;
	}
	
}
