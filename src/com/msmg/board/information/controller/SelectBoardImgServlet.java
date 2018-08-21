package com.msmg.board.information.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.msmg.board.information.model.vo.Attachment;
import com.msmg.board.information.model.vo.Board;
import com.msmg.common.MyFileRenamePolicy;
import com.msmg.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class SelectBoardImgServlet
 */
@WebServlet("/selectBoardImg")
public class SelectBoardImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println(root);
			
			String savePath = root + "information_uploadFiles/";
			
			//FileRenamePolicy 상속 후 오버라이딩
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//다중 파일을 묶어서 업로드 하기 위해 컬렉션 생성
			//저장한 파일의 이름을 저장할 arrayList 생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본파일의 이름을 저장할 arrayList를 생성
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//파일이 전송된 이름을 반환
			Enumeration<String> files = multiRequest.getFileNames();
			
			//각 파일의 정보를 구해온 후 DB에 저장할 목적의 데이터를 꺼내온다.
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
			
			//multipartRequest객체에서 파일 외의 값을 가져올 수도 있다.
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			System.out.println(title);
			System.out.println(content);
			System.out.println(saveFiles);
			System.out.println(originFiles);
			
			//Board객체 생성
			Board b = new Board();
			b.setTitle(title);
			b.setContent(content);
			b.setuCode(String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getU_code()));
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			
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
