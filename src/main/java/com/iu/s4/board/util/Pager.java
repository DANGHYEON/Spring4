package com.iu.s4.board.util;

public class Pager {
	
	private Long pn;
	private Long perPage;
	
	private Long startRow;
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	
	private Long totalPage;
	
	private String kind;
	private String search;


	

	public void makeNum(Long totalCount) {
		//1. totalCount
		//Long totalCount = 210L;
		
		//2. totalPage 구하기
		totalPage = totalCount / this.getPerPage();
		
		if(totalCount%this.getPerPage() !=0) {
			totalPage = totalPage+1;
		}
		
		//3. totalBlock 구하기
		Long totalBlock = totalPage / 5;
		
		if(totalPage%5 !=0) {
			totalBlock = totalBlock+1;
		}
		
		//4. pn으로 curBlock 구하기
		if(totalPage< this.getPn()) {
			this.setPn(totalPage);
		}
		
		Long curBlock = this.getPn()/5;
		
		if(this.getPn()%5 !=0) {
			curBlock = curBlock+1;
		}
		
		//5. curblock으로 시작번호와 마지막 번호 구하기
		this.startNum=(curBlock-1)*5+1;
		this.lastNum=curBlock*5;
		
		if(curBlock == totalBlock) { //현재 블럭 번호랑 총 블럭 번호가 같다면?
			
			this.lastNum=totalPage;
			
		}
		
		
		
	}
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage()+1;
		this.lastRow = this.getPn() * this.getPerPage();
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
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10L;
			
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPn() {
		if(this.pn==null || this.pn<=0) {
			this.pn=1L;
		}
		
		return pn;
	}
	public void setPn(Long pn) {
		this.pn = pn;
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
	
	public Long getTotalPage() {
		return totalPage;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
