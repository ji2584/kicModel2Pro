package controller;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Board;

@WebServlet("/board/*")
public class BoardController extends MskimRequestMapping {
	
	
	
	@RequestMapping("index")////*****//board//index
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
  	  	return"/WEB-INF/view/board/index.jsp";

	} 
	
	@RequestMapping("boardForm")////*****//board//index
    public String boardForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
  	  	return"/WEB-INF/view/board/boardForm.jsp";

	} 
	
	@RequestMapping("boardPro")////*****//board//index
    public String boardPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = request.getServletContext().getRealPath("/")+ "image/board/";
		String filename = null;
		String msg = "게시물 등록실패";
		String url = "/board/boardForm";
	
		MultipartRequest multi = new MultipartRequest(request,path,10*1024*1024,"UTF-8");
		
		Board board = new Board();
		board.setBoardid("1");
		board.setName(multi.getParameter("name"));
		board.setPass(multi.getParameter("pass"));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		board.setName(multi.getFilesystemName("file1"));
		System.out.println(board);
		BoardDao bd = new BoardDao();
		int num = bd.insertBoard(board);
		
		
		
		
		
		System.out.println("===========");
		request.setAttribute("msg","게시판이 입력되었습니다");
		request.setAttribute("url", "/board/boardList");
  	  	return"/WEB-INF/view/alert.jsp";

	} 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
