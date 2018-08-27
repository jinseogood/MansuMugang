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
 * Servlet implementation class EditNoticeServlet
 */
@WebServlet("/editNotice.no")
public class EditNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//멀티 파트 변환
		if(ServletFileUpload.isMultipartContent(request)){
			int maxSize = 1024 * 1024 * 10; // 사이즈
			
			String root = request.getSession().getServletContext().getRealPath("/"); // 초기 경로

			//경로 설정
			String savePath = root + "attach_file/doc_file/";
			
			//멀티파트로 변경
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new RenameFilePolicy());
			
			//바뀐 이름
			ArrayList<String> saveFiles = new ArrayList<String>();
			
			//기존 이름
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//이름만 저장
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()){
				
				String name = files.nextElement();
				
				//썸머노트에 저장된 파일 외 파일이름 저장
				if(!name.equals("files")){
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
					
				}
				
			}
			
			String title = multiRequest.getParameter("title"); // 제목
			String content = multiRequest.getParameter("smnoteval"); // 내용
			int bno = Integer.parseInt(multiRequest.getParameter("bno")); //글번호
			int ucode = Integer.parseInt(multiRequest.getParameter("num")); // 글쓴이
			
			//객체로 저장
			Notice no = new Notice();
			no.setTitle(title);
			no.setContent(content);
			no.setBoard_no(bno);
			
			//첨부파일 리스트 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			//첨부파일 저장
			for(int i = originFiles.size() - 1; i >= 0; i--){
				Attachment at = new Attachment();
				
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				at.setBoard_no(bno);

				fileList.add(at);
			}

			//기존 공지에 있던 파일의 변경 이름 저장
			ArrayList<String> nameList = new NoticeService().selectChangeName(bno);
			
			//파일이 존재 시 삭제
			if(nameList != null){
				for(int i = 0; i < nameList.size(); i++){
					File deleteFile = new File(savePath + nameList.get(i));
					deleteFile.delete();
				}
			}
			System.out.println("파일 삭제 완료");

			//파일 및 공지 저장
			int result = new NoticeService().editNotice(no, fileList, ucode);
			
			System.out.println("수정완료");
			
			if(result > 0){
				response.sendRedirect(request.getContextPath() + "/noticeDetail.admin?board_no=" + no.getBoard_no());
			}else{
				for(int i = 0; i < saveFiles.size(); i++){
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				
				request.setAttribute("msg", "공지사항 작성 에러");
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
