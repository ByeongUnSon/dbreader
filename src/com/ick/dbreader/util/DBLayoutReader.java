package com.ick.dbreader.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBLayoutReader {
	
	
	// ��� �����
	public static final String hCommSql = "select name, "
			+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
			+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
			+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
			+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
			+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
			+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
			+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
			+ "as mciMsgCtnt FROM dbown.iofrmt_mst where NAME = 'pfmihead_msg'";
	
	// ��� ������
	public static final String hEachSql = "select name, "
			+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
			+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
			+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
			+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
			+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
			+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
			+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
			+ "as mciMsgCtnt from dbown.iofrmt_mst "
			+ "where SCRIPT_TYPE = 'M' and CATEGORY = '/' and NAME = 'pfmdhdr_msg'";
	
	// ���� �����
	public static final String wCommSql = "select name, "
			+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
			+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
			+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
			+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
			+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
			+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
			+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
			+ "as mciMsgCtnt from dbown.iofrmt_mst "
			+ "where SCRIPT_TYPE = 'M' and CATEGORY = '/' and NAME like '%_msg'";
	
	// ���� ������
	public static final String wEachSql = "select name, "
			+ "TO_CLOB(TO_CLOB(SCRIPT01) || TO_CLOB(SCRIPT02) || TO_CLOB(SCRIPT03) || "
			+ "TO_CLOB(SCRIPT04) || TO_CLOB(SCRIPT05) || TO_CLOB(SCRIPT06) || "
			+ "TO_CLOB(SCRIPT07) || TO_CLOB(SCRIPT08) || TO_CLOB(SCRIPT09) || "
			+ "TO_CLOB(SCRIPT10) || TO_CLOB(SCRIPT11) || TO_CLOB(SCRIPT12) || "
			+ "TO_CLOB(SCRIPT13) || TO_CLOB(SCRIPT14) || TO_CLOB(SCRIPT15) || "
			+ "TO_CLOB(SCRIPT16) || TO_CLOB(SCRIPT17) || TO_CLOB(SCRIPT18) || "
			+ "TO_CLOB(SCRIPT19) || TO_CLOB(SCRIPT20) ) "
			+ "as mciMsgCtnt from dbown.iofrmt_mst "
			+ "where SCRIPT_TYPE = 'M' and CATEGORY = '/' and NAME like '%_msg'";
	
	public DBLayoutReader() {}
	
	protected DBCPUtil dbcpUtil;
	
	/**
	 * Constructor
	 * 
	 * @param dbcpUtil
	 */
	public DBLayoutReader(DBCPUtil dbcpUtil) {
		this.dbcpUtil = dbcpUtil;
	}
	
	public void start(String driverClass, String url, String userName, String passWord) {
		dbcpUtil.openConnection(driverClass, url, userName, passWord);
	}
	
	public void close() {
		dbcpUtil.closeConnection();
	}
	
	public ArrayList<TestCaseDetailDTO> getStrucDto() throws SQLException {
		String msgCtnt = "";

		ResultSet rs = dbcpUtil.selectQuery(DBLayoutReader.hCommSql);

		while (rs.next()) {
			msgCtnt = rs.getString("mciMsgCtnt");
		}
			
		ArrayList<TestCaseDetailDTO> detailList = new ArrayList<TestCaseDetailDTO>();
		
		TestCaseDetailDTO detailDto;
		
		try {
			msgCtnt = msgCtnt.substring(msgCtnt.indexOf("{")+1, msgCtnt.indexOf("}"));
			
			System.out.println("msgCtnt: " + msgCtnt);
			
			String [] str = msgCtnt.split(";");
			
			for (int i=0; i<str.length; i++) {
				System.out.println("str[" + i + "]" + str[i]);
			}
						
			for (int i = 0; i < str.length; i++) {

				if (str[i].indexOf("DECLARE(") != -1) {
					String declareFld = str[i].substring(str[i].indexOf("(")+1, str[i].indexOf(")"));
					String [] declareFldInfo = declareFld.split(",");

					detailDto = new TestCaseDetailDTO();
					detailDto.setTscsFldAttriCtnt("text");								// �Ӽ� ����(hidden,text,column) 
					detailDto.setTscsFldType(declareFldInfo[0].trim().substring(0,1)); 	// Ÿ��
					detailDto.setTscsFldName(declareFldInfo[1].trim());					// �ʵ��
					detailDto.setTscsFldSizeCtnt(declareFldInfo[3].trim());				// ���̰�
					detailDto.setTscsObj("fld"); 										// obj����(fld,column,obj)
					detailDto.setTscsFldDataCtnt("");									// �����Ͱ� 
					
					if ((i+1<str.length) && (str[i+1].indexOf("PROPERTY(")!= -1)){
						String comment = str[i+1].substring(str[i+1].indexOf("(")+1);
						String [] commentInfo = comment.split(",");
						commentInfo[2] = commentInfo[2].substring(0, commentInfo[2].indexOf(")"));
						detailDto.setTscsFldType(detailDto.getTscsFldType()+"("+commentInfo[2].trim()+")"); 	
						i++;
					}		
					
					if ((i+1<str.length) && (str[i+1].indexOf("COMMENT(")!= -1)){
						String comment = str[i+1].substring(str[i+1].indexOf("(")+1);
						String [] commentInfo = comment.split("\"");
						detailDto.setTscsFldDesc(commentInfo[1].trim());
						i++;
					}					                         
					
					detailList.add(detailDto);					
				} 
			}			
			
		} catch (Exception e) {
		}
		return detailList;
	}
}
