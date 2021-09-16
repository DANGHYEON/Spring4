package com.iu.s4.board.notice;

import java.util.List;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;

public class NoticeDTO extends BoardDTO {
	
	private List<BoardFilesDTO> files;

	public List<BoardFilesDTO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}

}
