package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

import javax.persistence.*;
@Entity
@Table(name="user_detail")
public class UserDetail implements Comparable<UserDetail>,Serializable{
private static final long serialVersionUID = 5731332744337394984L;
@Id @GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(nullable=false)
private String firstName;
@Column(nullable=false)
private String lastName;
@Column(nullable=false)
private Date dob;
@Column(nullable=false)
private String collegeName;
@Column(nullable=false)
private String course;
@Column(nullable=false)
private String address;
@Column(nullable=false, unique=true)
private String email;
@Column(nullable=false,unique=true)
private String phoneNumber;
@OneToMany
private Collection<Complain>complains=new TreeSet<>();
@OneToOne(mappedBy="userDetail",cascade=CascadeType.ALL)
private UserLogin userLogin;
/*public UserLogin getUserLogin() {
	return userLogin;
}
public void setUserLogin(UserLogin userLogin) {
	this.userLogin = userLogin;
}
*/
public Collection<Complain> getComplains() {
	return complains;
}
public void setComplains(Collection<Complain> complains) {
	this.complains = complains;
}
public UserDetail(int id, String firstName, String lastName, Date dob, String collegeName, String course,
		String address, String email, String phoneNumber) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.collegeName = collegeName;
	this.course = course;
	this.address = address;
	this.email = email;
	this.phoneNumber = phoneNumber;
}
public UserDetail(String firstName, String lastName, Date dob, String collegeName, String course, String address,
		String email, String phoneNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.collegeName = collegeName;
	this.course = course;
	this.address = address;
	this.email = email;
	this.phoneNumber = phoneNumber;
}
public UserDetail() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getCollegeName() {
	return collegeName;
}
public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
			+ ", collegeName=" + collegeName + ", course=" + course + ", address=" + address + ", email=" + email
			+ ", phoneNumber=" + phoneNumber + "]";
}
@Override
public int compareTo(UserDetail arg0) {
	return this.getId()-arg0.getId();
}

}
