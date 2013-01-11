package com.ick.dbreader.tester;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.ick.dbreader.util.DBCPUtil;

public class SelectTest {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@demo-server:1521:ORCL";
		String user = "inst1";
		String pass = "inst1";

		DBCPUtil dbcpUtil = DBCPUtil.getInstance();
		dbcpUtil.openConnection(driverClass, url, user, pass);

		printHeaderComm(dbcpUtil); 
		//printHeaderEach(dbcpUtil);
		//printWorkComm(dbcpUtil);
		//printWorkEach(dbcpUtil);
		
		dbcpUtil.closeConnection();

	}

	// 헤더 공통부
	static void printHeaderComm(DBCPUtil dbcpUtil) throws SQLException {

		String hCommSql = "select name, "
				+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
				+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
				+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
				+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
				+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
				+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
				+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
				+ "as mciMsgCtnt FROM dbown.iofrmt_mst where NAME = 'pfmihead_msg'";

		ResultSet rs = dbcpUtil.selectQuery(hCommSql);

		while (rs.next()) {
			System.out.println(rs.getString("mciMsgCtnt"));
		}
	}

	// 헤더 개별부
	static void printHeaderEach(DBCPUtil dbcpUtil) throws SQLException {

		String hEachSql = "select name, "
				+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
				+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
				+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
				+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
				+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
				+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
				+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
				+ "as mciMsgCtnt from dbown.iofrmt_mst "
				+ "where SCRIPT_TYPE = 'M' and CATEGORY = '/' and NAME = 'pfmdhdr_msg'";

		ResultSet rs = dbcpUtil.selectQuery(hEachSql);

		while (rs.next()) {
			System.out.println(rs.getString("mciMsgCtnt"));
		}
	}

	// 업무 공통부
	static void printWorkComm(DBCPUtil dbcpUtil) throws SQLException {

		String wCommSql = "select name, "
				+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
				+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
				+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
				+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
				+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
				+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
				+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
				+ "as mciMsgCtnt from dbown.iofrmt_mst "
				+ "where SCRIPT_TYPE = 'M' and CATEGORY = '/' and NAME like '%_msg'";

		ResultSet rs = dbcpUtil.selectQuery(wCommSql);

		while (rs.next()) {

			System.out.println(rs.getString("mciMsgCtnt"));

		}

	}

	// 업무 개별부
	static void printWorkEach(DBCPUtil dbcpUtil) throws SQLException {

		String wEachSql = "select name, "
				+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
				+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
				+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
				+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
				+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
				+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
				+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
				+ "as mciMsgCtnt from dbown.iofrmt_mst "
				+ "where SCRIPT_TYPE = 'M' and CATEGORY = '/' and NAME like '%_msg'";

		ResultSet rs = dbcpUtil.selectQuery(wEachSql);

		while (rs.next()) {
			System.out.println(rs.getString("mciMsgCtnt"));
		}
	}

}
