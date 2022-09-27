package member.model;

import java.util.Date;

public class Member {
	private String id;
	private String password;
	private String nickname;
	
	public Member(String id, String password, String nickname) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getNickname() {
		return nickname;
	}
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
}
