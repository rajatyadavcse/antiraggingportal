package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "complain")
public class Complain implements Comparable<Complain>, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Column(nullable = false)
	private String complainantName;
	@Column(nullable = false)
	private String victimName;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String mobileNumber;
	@Column(nullable = false)
	private String collegeName;
	@Column(nullable = false)
	private String yourAddress;
	@Column(nullable = false)
	private int pincode;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private Date registeredOn;
	@Column(nullable = false)
	private String raggingDetails;
	@Column(columnDefinition = "BLOB")
	private byte[] photoProof;
	@Column
	private int uid;
	public Complain(int id, String complainantName, String victimName, String email, String mobileNumber,
			String collegeName, String yourAddress, int pincode, String state, Date registeredOn, String raggingDetails,
			byte[] photoProof, int uid, ComplaintResponse response) {
		super();
		this.id = id;
		this.complainantName = complainantName;
		this.victimName = victimName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.collegeName = collegeName;
		this.yourAddress = yourAddress;
		this.pincode = pincode;
		this.state = state;
		this.registeredOn = registeredOn;
		this.raggingDetails = raggingDetails;
		this.photoProof = photoProof;
		this.uid = uid;
	}

	public Complain(int id, String complainantName, String victimName, String email, String mobileNumber,
			String collegeName, String yourAddress, int pincode, String state, Date registeredOn, String raggingDetails,
			byte[] photoProof, int uid) {
		super();
		this.id = id;
		this.complainantName = complainantName;
		this.victimName = victimName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.collegeName = collegeName;
		this.yourAddress = yourAddress;
		this.pincode = pincode;
		this.state = state;
		this.registeredOn = registeredOn;
		this.raggingDetails = raggingDetails;
		this.photoProof = photoProof;
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getComplainantName() {
		return complainantName;
	}

	public void setComplainantName(String complainantName) {
		this.complainantName = complainantName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcomplainantName() {
		return complainantName;
	}

	public void setcomplainantName(String complainantName) {
		this.complainantName = complainantName;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getYourAddress() {
		return yourAddress;
	}

	public void setYourAddress(String yourAddress) {
		this.yourAddress = yourAddress;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}

	public String getRaggingDetails() {
		return raggingDetails;
	}

	public void setRaggingDetails(String raggingDetails) {
		this.raggingDetails = raggingDetails;
	}

	public byte[] getPhotoProof() {
		return photoProof;
	}

	public void setPhotoProof(byte[] photoProof) {
		this.photoProof = photoProof;
	}
	public Complain() {
		super();
		this.id = 0;
		this.complainantName = null;
		this.victimName = null;
		this.email = null;
		this.mobileNumber = null;
		this.collegeName = null;
		this.yourAddress = null;
		this.pincode = 0;
		this.state = null;
		this.registeredOn = null;
		this.raggingDetails = null;
		this.photoProof = null;
	}

	public Complain(int id, String complainantName, String victimName, String email, String mobileNumber,
			String collegeName, String yourAddress, int pincode, String state, Date registeredOn, String raggingDetails,
			byte[] photoProof) {
		super();
		this.id = id;
		this.complainantName = complainantName;
		this.victimName = victimName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.collegeName = collegeName;
		this.yourAddress = yourAddress;
		this.pincode = pincode;
		this.state = state;
		this.registeredOn = registeredOn;
		this.raggingDetails = raggingDetails;
		this.photoProof = photoProof;
	}

	public Complain(String complainantName, String victimName, String email, String mobileNumber, String collegeName,
			String yourAddress, int pincode, String state, Date registeredOn, String raggingDetails,
			byte[] photoProof) {
		super();
		this.complainantName = complainantName;
		this.victimName = victimName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.collegeName = collegeName;
		this.yourAddress = yourAddress;
		this.pincode = pincode;
		this.state = state;
		this.registeredOn = registeredOn;
		this.raggingDetails = raggingDetails;
		this.photoProof = photoProof;
	}
	@Override
	public int compareTo(Complain arg0) {
		return this.getId() - arg0.getId();
	}

	@Override
	public String toString() {
		return "Complain [id=" + id + ", complainantName=" + complainantName + ", victimName=" + victimName + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", collegeName=" + collegeName + ", yourAddress="
				+ yourAddress + ", pincode=" + pincode + ", state=" + state + ", registeredOn=" + registeredOn
				+ ", raggingDetails=" + raggingDetails + ", photoProof=" + Arrays.toString(photoProof) + "]";
	}

}
