package model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserLogin {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@Column(unique=true,nullable=false)
private String username;
	@Column(nullable=false)
private String password;
	@OneToOne(cascade=CascadeType.ALL)
private UserRole userRole;
	@OneToOne(cascade=CascadeType.ALL)
private UserDetail userDetail;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserRole getUserRole() {
	return userRole;
}
public void setUserRole(UserRole userRole) {
	this.userRole = userRole;
}
public UserLogin(int id, String username, String password, UserRole userRole) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.userRole = userRole;
}
public UserLogin(String username, String password, UserRole userRole) {
	super();
	this.username = username;
	this.password = password;
	this.userRole = userRole;
}
public UserLogin(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public UserLogin() {
	super();
}
@Override
public String toString() {
	return "UserLogin [id=" + id + ", username=" + username + ", password=" + password + "]";
}
public UserDetail getUserDetail() {
	return userDetail;
}
public void setUserDetail(UserDetail userDetail) {
	this.userDetail = userDetail;
}

}
