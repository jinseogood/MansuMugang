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
			
			String savePath = root + "attach_file/doc_file/"; //문서 저장 경로
			
			//FileReNamepolicy 상속 후 오버라이딩
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new RenameFilePolicy());
			
			//저장한 파일의 이름을 저장할 리스트 생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			
			//원본 파일의 이름을 저장할 리스트 생성
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//파일이 전송된 이름을 반환
			Enumeration<String> files = multiRequest.getFileNames();
			
			//각 파일의 정보를 구해온 후 DB에 저장 할 목적으로 가져온다
			while(files.hasMoreElements()){
				
				String name = files.nextElement();

				//썸머노트 에디터 외 파일만 저장
				if(!name.equals("files")){
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
					
				}
			}
			
			String title = multiRequest.getParameter("title"); // 제목
			String content = multiRequest.getParameter("smnoteval"); // 내용
			int bno = Integer.parseInt(multiRequest.getParameter("bno")); // 글번호
			int ucode = Integer.parseInt(multiRequest.getParameter("num")); // 유저 코드
			
			//Board객체 생성
			Notice no = new Notice();
			no.setTitle(title);
			no.setContent(content);
			no.setBoard_no(bno);
			
			//attachment 객체 생성해서 리스트 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			//전송순서 역순으로 파일이 list에 저장되기 때문에 반복문을 역으로 수행
			for(int i = originFiles.size() - 1; i >= 0; i--){
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));

				fileList.add(at);
			}
			
			//Service로 전송
			int result = new NoticeService().updateBoard(no, fileList, ucode);

			//해당 글번호 내용으로 이동
			if(result > 0){
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
