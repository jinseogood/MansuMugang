package com.msmg.board.information.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msmg.board.information.model.service.BoardService;
import com.msmg.board.review.model.vo.BoardFile;
import com.msmg.common.RenameFilePolicy;
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
		//전송 파일에 대한 용량 제한 : 10MB
		int maxSize = 1024 * 1024 * 10;
		
		//웹서버 컨테이너 경로 추출함
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println(root);
		
		String savePath = root + "attach_file/pic_file/"; //사진 저장 경로
		
		//FileReNamepolicy 상속 후 오버라이딩
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new RenameFilePolicy());
		
		//저장한 파일의 이름을 저장할 변수 생성
		String saveFile = "";
		
		//원본 파일의 이름을 저장할 변수 생성
		String originFile = "";
		
		//파일이 전송된 이름을 반환한다.
		Enumeration<String> files = multiRequest.getFileNames();
		
		//각 파일의 정보를 구해온 후 DB에 저장할 목적의 데이터를 꺼내온다
		while(files.hasMoreElements()){
			String name = files.nextElement();
			
			saveFile = multiRequest.getFilesystemName(name);
			originFile = multiRequest.getOriginalFileName(name);
			
		}
		int bno = Integer.parseInt(multiRequest.getParameter("bno"));
		int ucode = Integer.parseInt(multiRequest.getParameter("num"));
		
		//전송순서 역순으로 파일이 list에 저장되기 때문에 반복문을 역으로 수행
		BoardFile bf = new BoardFile();
		bf.setFile_src(savePath);
		bf.setOrigin_name(originFile);
		bf.setEdit_name(saveFile);
		bf.setBoard_id(bno);
			
		
		//Service로 전송
		int result = new BoardService().insertBoardFile(bf, ucode);
		
		if(result > 0){
		String path2 = request.getContextPath()+"/attach_file/pic_file/" + saveFile;
		 
		JSONObject jobj = new JSONObject();
		jobj.put("url", path2); 
			
		String data = jobj.toString();
			
		response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
		response.setCharacterEncoding("UTF-8");
			
		//출력
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
