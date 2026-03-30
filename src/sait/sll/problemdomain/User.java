package sait.sll.problemdomain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String email;
	private String password;

	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public boolean isCorrectPassword(String password) {
	    if (this.password == null && password == null) {
	        return true;
	    }
	    if (this.password == null || password == null) {
	        return false;
	    }
	    return this.password.equals(password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		User other = (User) obj;
		return id == other.id && 
			   Objects.equals(name, other.name) && 
			   Objects.equals(email, other.email) && 
			   Objects.equals(password, other.password);
	}
}
