package com.ick.dbreader.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class DBCPUtil {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static DBCPUtil instance;
	
	private DBCPUtil() {}
	
	/** singleton
	 * 
	 * @return DBCPUtil instance
	 */
	synchronized public static DBCPUtil getInstance() {
		if (instance == null) {
			instance = new DBCPUtil();
		}
		return instance;
	}
	
	/** set connection
	 * 
	 * @param driverClass
	 * @param url
	 * @param user
	 * @param pass
	 */
	public void openConnection(final String driverClass, final String url, final String user, final String pass) {
		DataSource dataSource = setupDataSource(driverClass, url, user, pass);
		
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException sqlEx) {
			new ConnException("Connection Error", sqlEx);
		}
	}
	
	/** setup DataSource
	 * 
	 * @param driverClass
	 * @param url
	 * @param user
	 * @param pass
	 * @return DataSource
	 */
	public DataSource setupDataSource(final String driverClass, final String url, final String user, final String pass) {
		BasicDataSource basicSource = new BasicDataSource();
		basicSource.setDriverClassName(driverClass);
		basicSource.setUsername(user);
		basicSource.setPassword(pass);
		basicSource.setUrl(url);
		return basicSource;
	}
	
	/** DataSource close
	 * 
	 * @param dataSource
	 */
	public void shutDownDataSource(final DataSource dataSource) {
		try {
			BasicDataSource basicDataSource = (BasicDataSource) dataSource;
			basicDataSource.close();
		} catch (SQLException sqlEx) {
			new ConnException("Connection Error", sqlEx);
		}
	}

	
	/** select
	 * 
	 * @param sql
	 * @return ResultSet
	 */
	public ResultSet selectQuery(final String sql) {
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			return rs;
			
		} catch (SQLException sqlEx) {
			new ConnException("Connection Error", sqlEx);
		}
		return null;
	}
	
	
	// All close
	public void closeConnection() {
		
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException sqlEx) {
			new ConnException("Connection Error", sqlEx);
		}
				
		try {
			if (pstmt != null)
				pstmt.close();		
		} catch (SQLException sqlEx) {
			new ConnException("Connection Error", sqlEx);
		}
				
		try {
			if (conn != null)
				conn.close();		
		} catch (SQLException sqlEx) {
			new ConnException("Connection Error", sqlEx);
		}
		
	}

}
