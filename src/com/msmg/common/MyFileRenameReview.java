package com.msmg.common;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenameReview implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		int randomNumber = (int)(Math.random() * 100000);
		
		//확장자명 가져오기
		String name = oldFile.getName();
		String body = null;
		String ext = null;
		int dot = name.lastIndexOf(".");
		if(dot != -1) {
			//dot 전까지
			body = name.substring(0, dot);
			
			ext = name.substring(dot);
		} else {
			body = name;
			ext = "";
		}
		
		String fileName = ft.format(new Date(currentTime)) + randomNumber + ext;
		
		File newFile = new File(oldFile.getParentFile(), fileName);
		
		return newFile;
	}

}
