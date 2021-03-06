package net.multi.chatting;

public class User {
	// Field
		private String userid; // 아이디
		private String userpwd; // 암호
		private String nickName; // 닉네임
		
		// Constructor
		public User() {
		}

		public User(String userid, String userpwd, String nickName) {
			super();
			this.userid = userid;
			this.userpwd = userpwd;
			this.nickName = nickName;
		}
		// Getter/Setter
		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getUserpwd() {
			return userpwd;
		}

		public void setUserpwd(String userpwd) {
			this.userpwd = userpwd;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
}
