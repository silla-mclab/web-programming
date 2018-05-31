package com.example.test13.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
		Statement stmt = null;
		
		try {
			stmt = dbConn.createStatement();
			
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
		}
		catch (SQLException ex) {
			throw ex;
		}
		finally {
			if (stmt != null) stmt.close();
			disconnect();
		}
	
		return bookList;
	}
	
	public int insertBook(BookDto book) throws ClassNotFoundException, SQLException {
		int result = 0;	
		if (book == null)  return 0;
		
		connect();
		
//		Statement stmt = null;
		PreparedStatement stmt = null;
		try {
			String sql = "insert into " + db_table 
			+ " (code, title, writer, price) values (?, ?, ?, ?);";
			
//			stmt = dbConn.createStatement();
			stmt = dbConn.prepareStatement(sql);

			stmt.setString(1, book.getCode());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getWriter());
			stmt.setInt(4, book.getPrice());
			
			result = stmt.executeUpdate();
/*			
			String sql = "insert into " + db_table 
					+ " (code, title, writer, price) values (";
			sql += "'" + book.getCode() +"', ";
			sql += "'" + book.getTitle() +"', ";
			sql += "'" + book.getWriter() +"', ";
			sql += book.getPrice() +");";
			result = stmt.executeUpdate(sql);
*/			
		}
		catch(SQLException ex) {
			throw ex;
		}
		finally {
			if (stmt != null)  stmt.close();
			disconnect();
		}
		
		return result;
	}
	
	public int deleteBook(String code) throws ClassNotFoundException, SQLException {
		int result = 0;	
		if (code == null && code.length() == 0)  return 0;
		
		connect();
		
		Statement stmt = null;
		try {
			stmt = dbConn.createStatement();
			
			String sql = "delete from " + db_table 
					+ " where code = '" + code + "';";
			
			result = stmt.executeUpdate(sql);
		}
		catch(SQLException ex) {
			throw ex;
		}
		finally {
			if (stmt != null)  stmt.close();
			disconnect();
		}
		
		return result;
	}
	
	public int updateBook(BookDto book) throws ClassNotFoundException, SQLException {
		int result = 0;	
		if (book == null)  return 0;
		
		connect();
		
		Statement stmt = null;
		try {
			stmt = dbConn.createStatement();
			
			String sql = "update " + db_table + " set ";
			sql += "title = '" + book.getTitle() +"', ";
			sql += "writer = '" + book.getWriter() +"', ";
			sql += "price = " + book.getPrice();
			sql += " where code = '" + book.getCode() +"';";
			
			result = stmt.executeUpdate(sql);
		}
		catch(SQLException ex) {
			throw ex;
		}
		finally {
			if (stmt != null)  stmt.close();
			disconnect();
		}
		
		return result;
	}
	
}
