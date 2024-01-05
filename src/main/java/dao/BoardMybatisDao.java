package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Board;
import model.Comment;
import model.KicMember;
import mybatis.KicMemberAnno;
import mybatis.MybatisConnection;

public class BoardMybatisDao {
	
	public Connection getConnection() {
	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      
	         try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic", "1111");
	            return conn;
	         } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      
	   

	      return null;
	   }
	

	 SqlSession sqlSession = MybatisConnection.getConnection();
	 private static final String NS="board.";
	 
	 public int insertBoard(Board board) throws UnsupportedEncodingException, SQLException {
	      	
	   	        
	      
	         int num = sqlSession.insert(NS+"insertBoard",board);
	         sqlSession.commit();
	         return num;
	                  
	   }
	 
	 public List<Board> boardList(int pageInt, int limit, String boardid) throws UnsupportedEncodingException, SQLException {
		 
		 	Map map = new HashMap();
		 	map.put("boardid", boardid);
		 	map.put("start",(pageInt-1)*limit +1);
		 	map.put("end",pageInt * limit);
		 	return sqlSession.selectList(NS + "boardList",map);
         
      
		}
		
	 

public int boardCount(String boardid) throws UnsupportedEncodingException, SQLException {
		 
	return sqlSession.selectOne(NS + "boardCount",boardid);
}




	 public Board oneBoard(int num) throws UnsupportedEncodingException, SQLException {
		 
		 return sqlSession.selectOne(NS+"oneBoard",num);
	 }

	 
	  public int updateBoard(Board board) throws UnsupportedEncodingException, SQLException {
	      	
		  int num = sqlSession.update(NS+"updateBoard",board);
	         sqlSession.commit();
	         return num;
	                  
	   }
	  
	  public int boardDelete(int num) throws UnsupportedEncodingException, SQLException {
		  int num2 = sqlSession.update(NS+ "boardDelete",num);
		  sqlSession.commit();
		  return num2;
		  
	
         
       }
	  
	  public int insertComment(String comment, int num) throws UnsupportedEncodingException, SQLException {
	      Map map = new HashMap();
	      map.put("comment", comment);
	      map.put("num", num);

	      int num1 = sqlSession.insert(NS+"insertComment", map);

	      sqlSession.commit();
	      return num1;
	  }

	public List<Comment> commentList(int num) throws SQLException {
		return sqlSession.selectList(NS + "commentList",num);

}
}