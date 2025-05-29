package org.example.jsontopojo;

public class Notifications{
	private boolean sms;
	private boolean email;
	private Push push;

	public void setSms(boolean sms){
		this.sms = sms;
	}

	public boolean isSms(){
		return sms;
	}

	public void setEmail(boolean email){
		this.email = email;
	}

	public boolean isEmail(){
		return email;
	}

	public void setPush(Push push){
		this.push = push;
	}

	public Push getPush(){
		return push;
	}
}
