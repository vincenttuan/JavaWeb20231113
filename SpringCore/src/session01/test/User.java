package session01.test;

public class User {
	
	private final String name; // 外部變數
	private final int age;
	private final String email;
	
	public User(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.email = builder.email;
	}
	
	public static class Builder {
		private String name; // 內部變數
		private int age;
		private String email;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public User build() {
			return User(this);
		}
	}
	
	
	
}