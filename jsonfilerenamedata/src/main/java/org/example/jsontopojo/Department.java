package org.example.jsontopojo;

import java.util.List;

public class Department {
	private String head;
	private List<Team> teams;
	private String name;

	public void setHead(String head){
		this.head = head;
	}

	public String getHead(){
		return head;
	}

	public void setTeams(List<Team> teams){
		this.teams = teams;
	}

	public List<Team> getTeams(){
		return teams;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}