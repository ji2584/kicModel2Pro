package model;

public class Board {
		private int num;
		private String name;
		private String pass;
	   private String subject;
	   private String content; 
	   private String file1;
	   private String regdate ;
	   private String readcnt ;
	   private String boardid ;
	   
	   
	   public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	   public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getFile1() {
			return file1;
		}
		public void setFile1(String file1) {
			this.file1 = file1;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		public String getReadcnt() {
			return readcnt;
		}
		public void setReadcnt(String readcnt) {
			this.readcnt = readcnt;
		}
		public String getBoardid() {
			return boardid;
		}
		public void setBoardid(String boardid) {
			this.boardid = boardid;
		}
		@Override
		public String toString() {
			return "Board [num=" + num + ", name=" + name + ", pass=" + pass + ", subject=" + subject + ", content="
					+ content + ", file1=" + file1 + ", regdate=" + regdate + ", readcnt=" + readcnt + ", boardid="
					+ boardid + "]";
		}
		
		
		
		
	   
}
