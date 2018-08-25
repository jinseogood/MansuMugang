package com.msmg.board.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.msmg.board.notice.model.service.NoticeService;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;
import com.msmg.common.RenameFilePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateNotice.no")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)){
			//전송 파일에 대한 용량 제한 : 10MB
			int maxSize = 1024 * 1024 * 10;
			
			//웹서버 컨테이너 경로 추출함
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root);
			
			String savePath = root + "attach_file/doc_file/";
			
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
			
			//원본 파일의 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//파일이 전송된 이름을 반환한다.
			Enumeration<String> files = multiRequest.getFileNames();
			
			//각 파일의 정보를 구해온 후 DBㅇ 저장할 목적의 데이터를 꺼내온다
			while(files.hasMoreElements()){
				
				String name = files.nextElement();
				System.out.println("update : " +  name);
				if(!name.equals("files")){
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
					
				}
				
				
				
			}
			
			//multipartRequest 객체에서 파일 외의 값을 가져올 수도 있다.
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("smnoteval");
			System.out.println(content);
			int bno = Integer.parseInt(multiRequest.getParameter("bno"));
			int ucode = Integer.parseInt(multiRequest.getParameter("num"));
			
			//Board객체 생성
			Notice no = new Notice();
			no.setTitle(title);
			no.setContent(content);
			no.setBoard_no(bno);
			
			//attachment 객체 생성해서 arrayList객체 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			//전송순서 역순으로 파일이 list에 저장되기 때문에 반복문을 역으로 수행
			for(int i = originFiles.size() - 1; i >= 0; i--){
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				System.out.println(at);
				fileList.add(at);
			}
			System.out.println("서비스로 전송전");
			//Service로 전송
			int result = new NoticeService().updateBoard(no, fileList, ucode);
			System.out.println("서비스로 전송후");
			if(result > 0){
				System.out.println("작성완료");
				response.sendRedirect(request.getContextPath() + "/noticeDetail.admin?board_no="+ result);
			}else{
				//실패시 저장된 사진 삭제
				for(int i = 0; i < saveFiles.size(); i++){
					//파일 시스템에 저장된 이름으로 파일 객체 생성함
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				
				//에러페이지로 forward
				request.setAttribute("msg", "공지사항 게시판 작성 에러");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
				
			}
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
