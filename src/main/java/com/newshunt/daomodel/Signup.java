package com.newshunt.daomodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class Signup 
{
@Id
String email_id;
String name;
String password;
String cpassword;
String phno;
String mychannel;
String favchannel;
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCpassword() {
	return cpassword;
}
public void setCpassword(String cpassword) {
	this.cpassword = cpassword;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
public String getMychannel() {
	return mychannel;
}
public void setMychannel(String mychannel) {
	this.mychannel = mychannel;
}
public String getFavchannel() {
	return favchannel;
}
public void setFavchannel(String favchannel) {
	this.favchannel = favchannel;
}



}
