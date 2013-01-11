package com.ick.dbreader.util;

public class TestCaseDetailDTO {
	
	private String tscsFldAttriCtnt; // 속성 구분(hidden, text, column)
	private String tscsFldType; 	 // 타입
	private String tscsFldName;		 // 필드명
	private String tscsFldSizeCtnt;	 // 길이값
	private String tscsObj;			 // obj구분 (fld, column, obj)
	private String tscsFldDataCtnt;	 // 데이터값
	private String tscsFldDesc;
	
	public String getTscsFldDesc() {
		return tscsFldDesc;
	}
	public void setTscsFldDesc(String tscsFldDesc) {
		this.tscsFldDesc = tscsFldDesc;
	}
	public String getTscsFldAttriCtnt() {
		return tscsFldAttriCtnt;
	}
	public void setTscsFldAttriCtnt(String tscsFldAttriCtnt) {
		this.tscsFldAttriCtnt = tscsFldAttriCtnt;
	}
	public String getTscsFldType() {
		return tscsFldType;
	}
	public void setTscsFldType(String tscsFldType) {
		this.tscsFldType = tscsFldType;
	}
	public String getTscsFldName() {
		return tscsFldName;
	}
	public void setTscsFldName(String tscsFldName) {
		this.tscsFldName = tscsFldName;
	}
	public String getTscsFldSizeCtnt() {
		return tscsFldSizeCtnt;
	}
	public void setTscsFldSizeCtnt(String tscsFldSizeCtnt) {
		this.tscsFldSizeCtnt = tscsFldSizeCtnt;
	}
	public String getTscsObj() {
		return tscsObj;
	}
	public void setTscsObj(String tscsObj) {
		this.tscsObj = tscsObj;
	}
	public String getTscsFldDataCtnt() {
		return tscsFldDataCtnt;
	}
	public void setTscsFldDataCtnt(String tscsFldDataCtnt) {
		this.tscsFldDataCtnt = tscsFldDataCtnt;
	}
	
}
