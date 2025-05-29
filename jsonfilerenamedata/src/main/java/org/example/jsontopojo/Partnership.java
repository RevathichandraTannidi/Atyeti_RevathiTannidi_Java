package org.example.jsontopojo;

public class Partnership {
	private String partner;
	private int startYear;
	private boolean active;

	public void setPartner(String partner){
		this.partner = partner;
	}

	public String getPartner(){
		return partner;
	}

	public void setStartYear(int startYear){
		this.startYear = startYear;
	}

	public int getStartYear(){
		return startYear;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}
}
