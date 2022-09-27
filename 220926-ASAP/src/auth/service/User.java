package auth.service;

public class User {
	private String id;
	private String nickname;
	
	public User(String id, String nickname) {
		super();
		this.id = id;
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

}
