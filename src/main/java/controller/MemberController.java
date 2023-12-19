package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.MemberDao;
import model.KicMember;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;

public class MemberController extends MskimRequestMapping {
	
	HttpSession session;
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	
	
	
	
			@RequestMapping("memberinput")
		      public String memberinput(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      
		    	  	return"/WEB-INF/view/member/memberinput.jsp";
      
			} 
			
			@RequestMapping("index")
		      public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      
		    	  	return"/WEB-INF/view/member/index.jsp";
    
			} 
			
			@RequestMapping("memberinfo")
		      public String memberinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
				MemberDao md = new MemberDao();
				HttpSession session = request.getSession();
				String login = (String)session.getAttribute("id");
				KicMember mem = md.oneMember(login);
				request.setAttribute("mem", mem);

				

		    	  	return"/WEB-INF/view/member/memberinfo.jsp";
  
			} 
			
			
			
			
			
			
			
    		@RequestMapping("loginForm")
    					public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
		    	  	return"/WEB-INF/view/member/loginForm.jsp";
		      	  	
    	  	
		    	  	
		    	  	
		    	  	
	}
    		

    		@RequestMapping("logout")
    					public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    				HttpSession session = request.getSession();
    				session.invalidate();
    				
    				
    				   request.setAttribute("msg", "logout 했습니다");
    	    		      request.setAttribute("url", "/member/loginForm");
    	    		
    	    	 	return"/WEB-INF/view/alert.jsp";
    	    	 	
		    	  
    	  	
		    	  	
		    	  	
		    	  	
	}
    		
    		
    		
    		
    		
    	@RequestMapping("loginPro")
		public String loginPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
  	      
    	 
      	  	
  	
    	String id = request.getParameter("id");
    	String pass = request.getParameter("pass");
    	MemberDao md = new MemberDao();
    	KicMember mem = md.oneMember(id);
    	HttpSession session = request.getSession();
    	String msg = "아이디를 확인하세요";
    	String url = "/member/loginForm";
    	if(mem !=null){
    		if(pass.equals(mem.getPass())){
    			session.setAttribute("id",id);
    			
    			msg = mem.getName()+"님이 로그인하셧습니다";
    			url = "/member/index";
    		}else {
    			msg = "비밀번호를 확인하세요 ";
    		}
    	}
    		   request.setAttribute("msg", msg);
    		      request.setAttribute("url", url);
    		
    	 	return"/WEB-INF/view/alert.jsp";
    	}
    	
    	
    	
    	
    	
    	
    	
    	@RequestMapping("memberPro")
    	
  public String memberPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	    	  
	    	  KicMember kicmem = new KicMember();
	    	  request.setCharacterEncoding("utf-8");
	    	  String id = request.getParameter("id");
	    	  String pass = request.getParameter("pass");
	    	  String name = request.getParameter("name");
	    	  int gender = Integer.parseInt(request.getParameter("gender")) ;
	    	  String tel = request.getParameter("tel");
	    	  String email = request.getParameter("email");
	    	  String picture = request.getParameter("picture");
	    	  kicmem.setId(id);
	    	  kicmem.setPass(pass);
	    	  kicmem.setName(name);
	    	  kicmem.setGender(gender);
	    	  kicmem.setTel(tel);
	    	  kicmem.setEmail(email);
	    	  kicmem.setPicture(picture);


	    	  MemberDao md = new MemberDao();
	    	  System.out.println(kicmem);
	    	  int num = md.insertMember(kicmem);
	    	  String msg = "저장 하였습니다.";
	    	  String url = "/member/loginForm";
	    	  
	    	  request.setAttribute("msg", msg);
	    	  request.setAttribute("url", url);
	    	  
	    	  return "/WEB-INF/view/alert.jsp";    	  
	    	  	    	  	    	  	    	  	    	  	    	  	    	  
	    	
	      
	      
}
    	
    	
    	
    	
		@RequestMapping("memberUpdateForm")
		public String memberUpdateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
	     HttpSession session = request.getSession();
	     String login = (String)session.getAttribute("id");
	     MemberDao md = new MemberDao();
	     KicMember mem = md.oneMember(login);
	     		
	     request.setAttribute("mem", mem);
	     
	     	return"/WEB-INF/view/member/memberUpdateForm.jsp";
 	
  


  	
}
    	
    	
    	
	 	
			@RequestMapping("memberUpdatePro")
			public String memberUpdatePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		     HttpSession session = request.getSession();
		     String login = (String)session.getAttribute("id");
		    
		     KicMember mem = new KicMember();//client에서 넘어온 자료

		     mem.setId(login);//session 저장 logout이면 에러남
		     mem.setPass(request.getParameter(("pass")));
		     mem.setName(request.getParameter(("name")));
		     mem.setGender(Integer.parseInt(request.getParameter(("gender"))));
		     mem.setTel(request.getParameter(("tel")));
		     mem.setEmail(request.getParameter(("email")));
		     mem.setPicture(request.getParameter(("picture")));
		     MemberDao md = new MemberDao();
		     KicMember memdb = md.oneMember(login);//db에서 넘어온 자료
		     String msg = "수정 되지 않았습니다";
		     String url="/member/memberUpdateForm";
		     if(memdb!=null){
		     	if(memdb.getPass().equals(mem.getPass())){//수정 ok
		     		
		     		msg ="수정되었습니다";
		     		
		     		md.UpdateMember(mem);
		     		url="/member/memberinfo";
		     	}else {
		     		msg = "비밀번호가 틀렸습니다.";
		     	}
		     	
		     }
		     

	    	  request.setAttribute("msg", msg);
	    	  request.setAttribute("url", url);
		     
		     
		     	return"/WEB-INF/view/alert.jsp";
	 	
	  


	  	
	}
    	

			@RequestMapping("memberDeleteForm")
			public String memberDeleteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		     HttpSession session = request.getSession();
		     String login = (String)session.getAttribute("id");
		     MemberDao md = new MemberDao();
		     KicMember mem = md.oneMember(login);
		     		
		     request.setAttribute("mem", mem);
		     
		     	return"/WEB-INF/view/member/memberDeleteForm.jsp";
	 	
	  


	  	
	}
			
			
			
			@RequestMapping("memberDeletePro")
			public String memberDeletePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
				HttpSession session = request.getSession();
				String login = (String)session.getAttribute("id");
				String pass = request.getParameter("pass");
				MemberDao md = new MemberDao();
				KicMember memdb = md.oneMember(login);
				String msg = "탈퇴되지 않았습니다.";
				String url = "/member/memberDeleteForm";
				if(memdb!=null){
					if(pass.equals(memdb.getPass())) { //비밀번호확인
					msg="탈퇴 됐습니다";
					
						md.DeleteMember(login);
						session.invalidate();
					url= "/member/index";
						
					}else{
						msg="비밀번호가 틀렸습니다.";
					}
								
					
				}

		    	  request.setAttribute("msg", msg);
		    	  request.setAttribute("url", url);
			     
			     
			     	return"/WEB-INF/view/alert.jsp";
		 	


	  	
	}
			
			
			@RequestMapping("memberPassForm")
			public String memberPassForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   
	 	
			     		
		
			     	return"/WEB-INF/view/member/memberPassForm.jsp";
		 	

	  	
	}
			
			
			@RequestMapping("memberPassPro")
			public String memberPassPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
				HttpSession session=request.getSession();
				
				String login = (String)session.getAttribute("id");
				
				String pass = request.getParameter("pass");
				String chgpass = request.getParameter("chgpass");
				
				
				MemberDao md = new MemberDao();
				KicMember memdb = md.oneMember(login);

				String msg = "비밀번호 수정을 실패 했습니다.";
				String url = "/member/memberPassForm";



				if(memdb!=null){
					if(memdb.getPass().equals(pass)){//수정 ok
						md.PassMember(login,chgpass);
						msg =login +"님이 비밀번호가 수정 되었습니다. ";
						url="/member/index";
					}else {
						msg = "비밀번호가 틀렸습니다.";
					}


				}

		    	  request.setAttribute("msg", msg);
		    	  request.setAttribute("url", url);
			     
			     
			     	return"/WEB-INF/view/alert.jsp";
		 	


	  	
	}
			
			@RequestMapping("pictureimgForm")
		      public String pictrueimgForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      
		    	  	return"/single/pictureimgForm.jsp";
  
			} 
			
			
			@RequestMapping("picturePro")
		      public String pictruePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
					String path=request.getServletContext().getRealPath("/")+"/image/member/picture/";
					System.out.println(path);
					String filename = null;
					
					try {
						MultipartRequest multi = new MultipartRequest(request,path,10*1024*1024,"UTF-8");
						
						filename = multi.getFilesystemName("picture");
						
					}catch(IOException e) {
						e.printStackTrace();
					}
					
					request.setAttribute("filename", filename);
					
					
							
					
					
					
		    	  	return"/single/picturePro.jsp";

			} 
			
    	
    	
    	}
    	
    	
    	
    		


