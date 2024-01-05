package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;


import model.KicMember;
import mybatis.KicMemberAnno;
import mybatis.MybatisConnection;

public class MemberMybatisDao {
	SqlSession sqlSession = MybatisConnection.getConnection();//class영역에 있어야함
    //MybatisConnection.close() 삭제
		   private static final String NS = "kicmember.";
		public int insertMember(KicMember kicmem) throws UnsupportedEncodingException, SQLException {
      	
     	 System.out.println("mybatis insertMember");
		
		
		
         int num = sqlSession.getMapper(KicMemberAnno.class).insertMember(kicmem);
         sqlSession.commit();
         
         return num;
                  
   }
 
          public KicMember oneMember(String id) throws SQLException {
        	                 
 
				
		   KicMember mem = sqlSession.getMapper(KicMemberAnno.class).oneMember(id);
		  
		   
		   return mem;
  
   
          }
          
          public int updateMember(KicMember kicmem) throws UnsupportedEncodingException, SQLException {

        	       	      
        	      int num = sqlSession.getMapper(KicMemberAnno.class).updateMember(kicmem); // dml -> commit()
        	      
        	      sqlSession.commit();
        	      return num;

        	   }
          
          public int deleteMember(String id) throws UnsupportedEncodingException, SQLException {
          	
        	
    	      
    	      int num = sqlSession.getMapper(KicMemberAnno.class).deleteMember(id); // dml -> commit()
    	      
    	      sqlSession.commit();
    	      return num;
                          
           }

          public int passMember(String id,String chgpass) throws UnsupportedEncodingException, SQLException {
        	     	              	    		
      		Map map = new HashMap();
      		map.put("id", id );
      		map.put("pass", chgpass);
      		
      		int num = sqlSession.getMapper(KicMemberAnno.class).passMember(map);
      		
      		sqlSession.commit();
      		return num;
                        
           }

}// class end