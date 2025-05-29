package org.example.jsontopojo;

import java.util.List;

public class Team {
	private List<MembersItem> members;
	private String name;
	private String lead;

	public void setMembers(List<MembersItem> members){
		this.members = members;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLead(String lead){
		this.lead = lead;
	}

	public String getLead(){
		return lead;
	}
}