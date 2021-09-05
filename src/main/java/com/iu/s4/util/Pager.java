package com.iu.s4.util;

public class Pager {
	
	private Long pn; 	  	//페이지 넘버
	private Long perPage; 	//요청 데이터 숫자. 10개면 10개의 데이터
	
	private Long startRow;	//
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	
	
	public void makeNum() {
		// 1. totalCount
		Long totalCount = 3L;    //나중에 totalCount는 DAO 랑 mapper에서 수정한 후 매개변수로 받아와야 할듯함.
		// 2. totalPage
		Long totalPage = totalCount / this.getPerPage();
		
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
		
		// 3. totalBlock 구하기
		Long totalBlock = totalPage / 5;
		
		if(totalPage%5 !=0) {
			totalBlock++;
		}
		
		//4. pn으로 curBlock 구하기
		Long curBlock = this.getPn()/5;
		
		if(this.getPn()%5 !=0) {
			curBlock++;
		}
		
		
		//5. curblock으로 시작 번호와 마지막 번호 구하기
		this.startNum=(curBlock-1)*5+1;
		this.lastNum = curBlock * 5;
		
	}
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage()+1;
		this.lastRow = this.getPn() * this.getPerPage();
	}
	
	
	public Long getPn() {
		if(this.pn==null || this.pn==0 ) {
			this.pn=1L;
		}
		
		return pn;
	}
	public void setPn(Long pn) {
		this.pn = pn;
	}
	public Long getPerPage() {
		if(this.perPage==null || this.perPage<=0) {
			this.perPage=10L;
		}
		
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	

}
