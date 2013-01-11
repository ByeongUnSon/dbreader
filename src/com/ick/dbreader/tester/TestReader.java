package com.ick.dbreader.tester;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ick.dbreader.util.DBCPUtil;
import com.ick.dbreader.util.DBLayoutReader;
import com.ick.dbreader.util.TestCaseDetailDTO;

public class TestReader {

	public static void main(String[] args) throws SQLException {
		
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@demo-server:1521:ORCL";
		String userName = "inst1";
		String passWord = "inst1";
		
		DBCPUtil dbcpUtil = DBCPUtil.getInstance();
		
		DBLayoutReader reader = new DBLayoutReader(dbcpUtil);
		reader.start(driverClass, url, userName, passWord);
		
		ArrayList<TestCaseDetailDTO> list = reader.getStrucDto();
		
		//System.out.println(list.size());
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getTscsFldAttriCtnt() + " ");
			System.out.println(list.get(i).getTscsFldDataCtnt() + " ");
			System.out.println(list.get(i).getTscsFldDesc() + " ");
			System.out.println(list.get(i).getTscsFldName() + " ");
			System.out.println(list.get(i).getTscsFldSizeCtnt() + " ");
			System.out.println(list.get(i).getTscsFldType() + " ");
			System.out.println(list.get(i).getTscsObj() + " ");
		}
	}

}
