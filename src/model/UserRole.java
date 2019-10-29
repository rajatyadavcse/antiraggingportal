package model;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@Column(nullable=false)
private String roleType;
	public UserRole(String roleType, String accountStatus) {
		super();
		this.roleType = roleType;
		this.accountStatus = accountStatus;
	}
	@Column(name="status",nullable=false)
private String accountStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getaccountStatus() {
		return accountStatus;
	}
	public void setaccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public UserRole(int id, String roleType, String accountStatus) {
		super();
		this.id = id;
		this.roleType = roleType;
		this.accountStatus = accountStatus;
	}
	public UserRole() {
		super();
	}
	
}
