package com.iu.s4.board.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.member.MemberFilesDTO;


@Component
public class FileManager {
	//파일 삭제
	public void fileDelete(File file) throws Exception {
		
		file.delete();
		
	}
	
	
	//fileSave
	//파일 저장
	public String fileSave(MultipartFile multipartFile, File file) throws Exception {
		if(!file.exists()) {
			file.mkdirs();
		}
		
		
		//파일명 생성
		String fileName= UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		file = new File(file,fileName);
		
		//저장
		//1. FileCopyUtils
		// FileCopyUtils.copy(multipartFile.getBytes(), file);
		//2. MultioartFile
		multipartFile.transferTo(file);
		
		return fileName;
		
	}
	
}
