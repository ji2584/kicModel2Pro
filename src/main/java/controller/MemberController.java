package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.KicMember;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;

public class MemberController extends MskimRequestMapping {
	
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
	    	  kicmem.setId(id);
	    	  kicmem.setPass(pass);
	    	  kicmem.setName(name);
	    	  kicmem.setGender(gender);
	    	  kicmem.setTel(tel);
	    	  kicmem.setEmail(email);


	    	  MemberDao md = new MemberDao();
	    	  int num = md.insertMember(kicmem);
	    	  String msg = "저장 하였습니다.";
	    	  String url = "/member/loginForm";
	    	  
	    	  request.setAttribute("msg", msg);
	    	  request.setAttribute("url", url);
	    	  
	    	  return "/WEB-INF/view/alert.jsp";    	  
	    	  	    	  	    	  	    	  	    	  	    	  	    	  
	    	
	      
	      
}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	}
    	
    	
    	
    		


