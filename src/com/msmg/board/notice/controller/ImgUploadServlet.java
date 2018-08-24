package com.msmg.board.notice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import com.msmg.board.notice.model.service.NoticeService;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;
import com.msmg.common.RenameFilePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ImgUploadServlet
 */
@WebServlet("/imgUpload.no")
public class ImgUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//전송 파일에 대한 용량 제한 : 10MB
			int maxSize = 1024 * 1024 * 10;
			
			//웹서버 컨테이너 경로 추출함
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root);
			
			String savePath = root + "attach_file/pic_file/";
			
			//사용자가 올린 파일명을 그대로 저장하지 않는 것이 일반적이다.
			//1. 같은 파일명이 있는 경우 이전파일 덮어 쓸 수 있다.
			//2. 한글로 된 파일명, 특수기호, 띄어쓰기등은 서버에 따라 문제가 생길 수 있다
			//DefaultFileRenamePolicy는 cos.jar안에 존재하는 클래스로
			//같은 파일명이 존재하는지 검사하고 있을 경우 뒤에 숫자를 붙여준다.
			//ex) aaa.zip, aaa1.zip, aaa2.zip
			//MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
			//FileReNamepolicy 상속 후 오버라이딩
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new RenameFilePolicy());
			
			//다중 파일을 묶어서 업로드 하기 위해 컬렉션을 생성한다.
			//저장한 파일의 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> saveFiles = new ArrayList<String>();
			String saveFile = "";
			
			//원본 파일의 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> originFiles = new ArrayList<String>();
			String originFile = "";
			
			//파일이 전송된 이름을 반환한다.
			Enumeration<String> files = multiRequest.getFileNames();
			
			//각 파일의 정보를 구해온 후 DBㅇ 저장할 목적의 데이터를 꺼내온다
			while(files.hasMoreElements()){
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
				
				saveFile = multiRequest.getFilesystemName(name);
				originFile = multiRequest.getOriginalFileName(name);
				
			}
			int bno = Integer.parseInt(multiRequest.getParameter("bno"));
			int ucode = Integer.parseInt(multiRequest.getParameter("num"));
			
			//attachment 객체 생성해서 arrayList객체 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			//전송순서 역순으로 파일이 list에 저장되기 때문에 반복문을 역으로 수행
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFile);
				at.setChangeName(saveFile);
				at.setBoard_no(bno);
				
			
			//Service로 전송
			int result = new NoticeService().insertThumbnail(at, ucode);
			
			if(result > 0){
			String path2 = request.getContextPath()+"/attach_file/pic_file/" + saveFile;
			 
			 JSONObject jobj = new JSONObject();
				jobj.put("url", path2); 
				
				String data = jobj.toString();
				
				response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
				response.setCharacterEncoding("UTF-8");
				
				PrintWriter out = response.getWriter();
				out.print(jobj.toJSONString());
				out.flush();
				out.close();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
