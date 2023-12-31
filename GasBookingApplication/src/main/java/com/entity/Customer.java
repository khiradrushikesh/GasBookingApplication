package com.entity;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "Cust_Login" )
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull
	private int cid;
	
	@NotNull
	@Size(min=3, message = "Customer Name is required")
	private String cname;
	
	@NotNull
	@Size(message = "Customer Email Id is not Valid")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String emailId;
	
	@NotNull
	@NotEmpty
	private String username;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@NotNull
	@Size(min=10, max=10,  message = "Customer Phone Number is required")
	private String cphoneno;
	
	@NotNull
	@Size(min=3, message = "Customer Address is required")
	private String caddress;
	
	@NotNull
	private int custCylinderId;
	
	@NotNull
	private int custBankId;
	
	@NotNull
	private int custAccountNo;
	
	@NotNull
	private String custIFSCcode;
	
	@NotNull
	private String custPANno;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCustCylinderId() {
		return custCylinderId;
	}

	public void setCustCylinderId(int custCylinderId) {
		this.custCylinderId = custCylinderId;
	}

	public int getCustBankId() {
		return custBankId;
	}

	public void setCustBankId(int custBankId) {
		this.custBankId = custBankId;
	}

	public int getCustAccountNo() {
		return custAccountNo;
	}

	public void setCustAccountNo(int custAccountNo) {
		this.custAccountNo = custAccountNo;
	}

	public String getCustIFSCcode() {
		return custIFSCcode;
	}

	public void setCustIFSCcode(String custIFSCcode) {
		this.custIFSCcode = custIFSCcode;
	}

	public String getCustPANno() {
		return custPANno;
	}

	public void setCustPANno(String custPANno) {
		this.custPANno = custPANno;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCphoneno() {
		return cphoneno;
	}

	public void setCphoneno(String cphoneno) {
		this.cphoneno = cphoneno;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", emailId=" + emailId + ", username=" + username
				+ ", password=" + password + ", cphoneno=" + cphoneno + ", caddress=" + caddress + ", custCylinderId="
				+ custCylinderId + ", custBankId=" + custBankId + ", custAccountNo=" + custAccountNo + ", custIFSCcode="
				+ custIFSCcode + ", custPANno=" + custPANno + "]";
	}

	
	
	

	
	
}	
