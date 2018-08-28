package com.msmg.admin.controller;

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

import com.msmg.admin.model.service.MenuService;
import com.msmg.admin.model.vo.Menu;
import com.msmg.admin.model.vo.MenuInfo;
import com.msmg.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/updateMenu")
public class UpdateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMenuServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mCode=Integer.parseInt(request.getParameter("menuCode"));
		
		String root=request.getSession().getServletContext().getRealPath("/");
		
		String filePath=root + "images/food/";
		String fileEditName=new MenuService().selectMenuFileName(mCode);
		
		File file=new File(filePath + fileEditName);
		file.delete();
		
		if(ServletFileUpload.isMultipartContent(request)){
			//전송 파일에 대한 용량 제한 : 10MB
			int maxSize=1024 * 1024 * 10;	//1024 * 1024 = 1Mb  바이트 단위계산
			
			//웹 서버 컨테이너 경로 추출함
			//String root=request.getSession().getServletContext().getRealPath("/");
			
			System.out.println(root);
			
			String savePath=root + "images/food/";
			
			//사용자가 올린 파일명을 그대로 저장하지 않는 것이 일반적이다.
			//1. 같은 파일명이 있는 경우 이전 파일을 덮어 쓸 수 있다.
			//2. 한글로된 파일명, 특수기호, 띄어쓰기 등은 서버에 따라서 문제가 생길 수 도 있다.
			//DefaultFileRenamePolicy는 cos.jar안에 존재하는 클래스로
			//같은 파일명이 존재하는지 검사하고,
			//있을 경우에는 파일명 뒤에 숫자를 붙여준다.
			//ex : aaa.zip, aaa1.zip, aaa2.zip
			//MultipartRequest multiRequest=new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			//FileRenamePolicy 상속 후 오버라이딩
			MultipartRequest multiRequest=new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//다중 파일을 묶어서 업로드 하기 위해 컬렉션을 생성한다.
			//저장한 파일의 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> saveFiles=new ArrayList<String>();
			//원본파일의 이름을 저장할 arrayList를 생성한다.
			ArrayList<String> originFiles=new ArrayList<String>();
			
			//파일이 전송된 이름을 반환한다.
			Enumeration<String> files=multiRequest.getFileNames();
			
			//각 파일의 정보를 구해온 후 DB에 저장할 목적의 데이터를 꺼내온다
			while(files.hasMoreElements()){
				String name=files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
			
			//multipartRequest객체에서 파일 외의 값을 가져올 수도 있다.
			//int mCode=Integer.parseInt(request.getParameter("menuCode"));
			String menuName=multiRequest.getParameter("menuName");
			String mainMat=multiRequest.getParameter("mainMat");
			String subMat=multiRequest.getParameter("subMat");
			String price=multiRequest.getParameter("price");
			String info=multiRequest.getParameter("info");
			
			System.out.println(mCode);
			System.out.println(menuName);
			System.out.println(mainMat);
			System.out.println(subMat);
			System.out.println(price);
			System.out.println(info);
			System.out.println(saveFiles);
			System.out.println(originFiles);
			
			//Menu객체 생성
			Menu menu=new Menu();
			menu.setMenuCode(mCode);
			menu.setMenuName(menuName);
			menu.setMainMat(mainMat);
			menu.setSubMat(subMat);
			menu.setPrice(Integer.parseInt(price));
			
			//Attachment객체 생성해서 arrayList객체 생성
			ArrayList<MenuInfo> fileList=new ArrayList<MenuInfo>();
			//전송순서 역순으로 파일이 list에 저장되기 때문에 반복문을 역으로 수행
			for(int i=originFiles.size()-1;i>=0;i--){
				MenuInfo mi=new MenuInfo();
				mi.setMenuCode(mCode);
				mi.setFilePath(savePath);
				mi.setOriginName(originFiles.get(i));
				mi.setEditName(saveFiles.get(i));
				mi.setInfo(info);
				
				fileList.add(mi);
			}
			
			//Service로 전송
			int result=new MenuService().updateMenu(menu, fileList);
			
			if(result>0){
				//response.sendRedirect(request.getContextPath() + "/selectMatAddMenu");
				System.out.println("수정 성공");
			}
			else{
				//실패 시 저장된 사진 삭제
				for(int i=0;i<saveFiles.size();i++){
					//파일시스템에 저장된 이름으로 파일 객체 생성함
					File failedFile=new File(savePath + saveFiles.get(i));
					
					failedFile.delete();
				}
				
				//에러페이지로 forward
				request.setAttribute("msg", "메뉴 등록 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
