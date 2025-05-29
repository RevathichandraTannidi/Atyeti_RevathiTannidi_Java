package org.example.jsontopojo;

import java.util.List;

public class Technologies{
	private Cloud cloud;
	private List<String> languages;
	private List<String> tools;

	public void setCloud(Cloud cloud){
		this.cloud = cloud;
	}

	public Cloud getCloud(){
		return cloud;
	}

	public void setLanguages(List<String> languages){
		this.languages = languages;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public void setTools(List<String> tools){
		this.tools = tools;
	}

	public List<String> getTools(){
		return tools;
	}
}