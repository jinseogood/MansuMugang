package com.msmg.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.Member;

@WebServlet("/emailCheck.me")
public class EmailCheckServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public EmailCheckServlet() {
        super();  
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String userId = request.getParameter("userId");
      String authenticationNum = "";
      int result = new MemberService().EmailCheck(userId);
      
      System.out.println(userId);
      
      //기존 회원 여부 확인
      String page = "";
      if(result > 0){
         response.getWriter().println(1);
    	  /*request.setAttribute("msg", "중복된 아이디");
    	  request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);*/
     
      }else{
         
         authenticationNum = randomStr();
         String subject = "만수무강에 오신것을 진심으로 환영합니다! 이메일 인증을 진행해 주세요.";
         String text = "\n만수무강에 오신걸 진심으로 환영합니다."
                   + "\n이메일 인증을 통해 회원가입을 완료해주시기 바랍니다."
                  + "\n이메일 인증을 완료하시면, 만수무강의 모든 서비스를 이용하실 수 있습니다. "
                  + "\n타인에게 정보가 유출될 경우 악용의 우려가 있으니 노출되지 않도록 각별히 주의하시기 바랍니다."
                  + "\n궁금하신 사항은 만수무강 고객센터(080-777-8281)로 연락 주시면 성심 성의껏 상담해드리겠습니다. 감사합니다."
                  + "\n\n<인증번호 : " + authenticationNum + ">"
                  + "\n\n\n\n\n\n\n\n\n\n\n";
         
         String username = "mansumugang4444@gmail.com";
         String password = "msmgmsmg4444";
          
         
          
         Properties props = new Properties(); 
         
              props.put("mail.smtp.user",username); 
              props.put("mail.smtp.password", password);
              props.put("mail.smtp.host", "smtp.gmail.com"); 
              props.put("mail.smtp.port", "25"); 
              props.put("mail.debug", "true"); 
              props.put("mail.smtp.auth", "true"); 
              props.put("mail.smtp.starttls.enable","true"); 
              props.put("mail.smtp.EnableSSL.enable","true");
              props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
              props.setProperty("mail.smtp.socketFactory.fallback", "false");   
              props.setProperty("mail.smtp.port", "465");   
              props.setProperty("mail.smtp.socketFactory.port", "465"); 
          
              Session session = Session.getInstance(props, new javax.mail.Authenticator() { 
              protected PasswordAuthentication getPasswordAuthentication() { 
              return new PasswordAuthentication(username, password); 
              }});
              System.out.println("??");
              try{
                  Message message = new MimeMessage(session); 
                  message.setFrom(new InternetAddress(username));
                  System.out.println("이멜 서블릿 userId전까지"); 
                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(userId)); 
                  System.out.println("이멜 서블릿 userId후");
                  message.setSubject(subject);
                  message.setText(text);
                  Transport.send(message); 
                  System.out.println("SEND");
                  
                  
              } catch(Exception e){
                  e.printStackTrace();
              }
              
         response.getWriter().println(authenticationNum);
         
      }
      
		
		page = "views/member/MemberJoinForm.jsp";
		request.setAttribute("authenticationNum", authenticationNum);
		
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
      
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      doGet(request, response);
   }

   public static String randomStr(){ 
         char strCollection[] = new char[] { 
                           '1','2','3','4','5','6','7','8','9','0', 
                           'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', 
                           'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', 
                           '!','@','#','$','%','^','&','*','(',')'};
 
         String ranStr = ""; 

         for (int i = 0; i < 10; i++) { 
           int selectRandomStr = (int)(Math.random()*(strCollection.length));
           ranStr += strCollection[selectRandomStr]; 
         } 
         
       return ranStr; 
     } 

}