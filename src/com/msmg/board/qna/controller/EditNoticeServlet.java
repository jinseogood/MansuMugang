package com.msmg.board.qna.controller;

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
@WebServlet("/editQna.qna")
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
		if(ServletFileUpload.isMultipartContent(request)){
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root);
			
			String savePath = root + "attach_file/doc_file/";
			

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new RenameFilePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			
			ArrayList<String> originFiles = new ArrayList<String>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()){
				
				String name = files.nextElement();
				
				if(!name.equals("files")){
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
					
				}
				
			}
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("smnoteval");
			int bno = Integer.parseInt(multiRequest.getParameter("bno"));
			
			Notice no = new Notice();
			no.setTitle(title);
			no.setContent(content);
			no.setBoard_no(bno);
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			
			for(int i = originFiles.size() - 1; i >= 0; i--){
				Attachment at = new Attachment();
				
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				at.setBoard_no(bno);

				fileList.add(at);
			}

			ArrayList<String> nameList = new NoticeService().selectChangeName(bno);
			
			if(nameList != null){
				for(int i = 0; i < nameList.size(); i++){
					File deleteFile = new File(savePath + nameList.get(i));
					deleteFile.delete();
				}
			}
			System.out.println("파일 삭제 완료");

			int result = new NoticeService().editNotice(no, fileList);
			
			System.out.println("수정완료");
			
			if(result > 0){
				response.sendRedirect(request.getContextPath() + "/noticeDetail.bo?board_no=" + no.getBoard_no());
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
