package com.example.test13.model;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class BookManagerDataSourceFactory {
	public static DataSource getMySQLDataSource(
			DBConnectionInfo info) {
		MysqlDataSource ds = new MysqlDataSource();
		
		ds.setUrl(info.getDbUrl());
		ds.setUser(info.getDbUser());
		ds.setPassword(info.getDbPassword());
		
		return ds;
	}
}
