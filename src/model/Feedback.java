package model;

import javax.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private int pincode;
	@Column(nullable=false)
	private String mobileNumber;
	@Column(nullable=false)
	private String state;
	@Column(nullable=false)
	private String feedback;
	public Feedback() {
		super();
	}
	public Feedback(String name, String address, String email, int pincode, String mobileNumber, String state,
			String feedback) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.state = state;
		this.feedback = feedback;
	}
	public Feedback(int id, String name, String address, String email, int pincode, String mobileNumber, String state,
			String feedback) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.state = state;
		this.feedback = feedback;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

}
