package com.msmg.board.review.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.msmg.board.information.model.vo.Board;
import com.msmg.board.review.model.service.ReviewService;
import com.msmg.board.review.model.vo.BoardFile;
import com.msmg.common.MyFileRenameReview;
import com.msmg.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class updateReviewListServlet
 */
@WebServlet("/updateList.rev")
public class updateReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("servletFileUpload 들어가기 전");
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("servletFileUpload 들어옴");
			
			int maxSize = 1024 * 1024 * 10;
			
			//웹 서버 컨테이너 경로 추출함
			String root = request.getSession().getServletContext().getRealPath("/");
			
			String savePath = root + "thumbnail_uploadFiles/";
			
			//FileRenamePolicy 상속 후 오버라이딩
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new MyFileRenameReview());
			
			//multipartRequest객체에서 파일 외의 값을 가져올 수도 있다.
			String uCode = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getU_code());
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String date = multiRequest.getParameter("date");
			String boardid = multiRequest.getParameter("boardId");
			String boardFile = multiRequest.getParameter("board_file");
			
			System.out.println("uCode : " + uCode);
			System.out.println("boardId : " + boardid);
			System.out.println("title : " + title);
			System.out.println("content : " + content);
			System.out.println("date : " + date);
			
			
			//다중 파일을 묶어서 업로드 하기 위해 컬렉션을 생성한다.
			//저장한 파일의 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본 파일 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//파일이 전송된 이름을 반환한다.
			Enumeration<String> files = multiRequest.getFileNames();
			
			//각 파일의 정보를 구해온 후 DB에 저장할 목적의 데이터를 꺼내온다
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
			
			System.out.println("saveFiles : " + saveFiles);
			System.out.println("originFiles : " + originFiles);
			
			
			java.sql.Date day = null;
			
			if(date != "" || date != null) {
				String[] dateArr = date.split("-");
				int[] arr = new int[dateArr.length];
				
				for(int i = 0; i < dateArr.length; i++) {
					arr[i] = Integer.parseInt(dateArr[i]);
				}
				
				day = new java.sql.Date(new GregorianCalendar(arr[0], arr[1]-1, arr[2]).getTimeInMillis());
				System.out.println(day);
				
			}else {
				day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
			}
			
			
			Board b = new Board();
			b.setTitle(title);
			b.setContent(content);
			b.setuCode(uCode);
			b.setBoardId(Integer.parseInt(boardid));
			
			
			
			//Attachment객체 생성해서 arrayList객체 생성
			ArrayList<BoardFile> fileList = new ArrayList<BoardFile>();
			
			for(int i = originFiles.size() - 1; i>= 0; i--) {
				BoardFile bf = new BoardFile();
				bf.setFile_src(savePath);
				bf.setOrigin_name(originFiles.get(i));
				bf.setEdit_name(saveFiles.get(i));
				bf.setFile_date(day);
				bf.setU_code(Integer.parseInt(uCode));				
				
				fileList.add(bf);
			}
			
			System.out.println("servlet fileList : " + fileList);
			
			
			int result = new ReviewService().updateReviewList(b, fileList);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/selectList.rev");
			}else {
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					
					failedFile.delete();
				}
				request.setAttribute("msg", "후기게시글 수정 실패!");
				request.getRequestDispatcher("views/common/errorPge.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
