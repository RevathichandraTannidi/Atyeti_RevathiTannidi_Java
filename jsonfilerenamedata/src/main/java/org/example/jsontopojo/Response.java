package org.example.jsontopojo;

import java.util.List;

public class Response{
	private Settings settings;
	private String country;
	private List<Project> projects;
	private int founded;
	private boolean active;
	private String services;
	private Technologies technologies;
	private Feedback feedback;
	private List<Partnership> partnerships;
	private Compliance compliance;
	private String company;
	private Location location;
	private List<Department> departments;
	private Announcements announcements;

	public void setSettings(Settings settings){
		this.settings = settings;
	}

	public Settings getSettings(){
		return settings;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setProjects(List<Project> projects){
		this.projects = projects;
	}

	public List<Project> getProjects(){
		return projects;
	}

	public void setFounded(int founded){
		this.founded = founded;
	}

	public int getFounded(){
		return founded;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setServices(String services){
		this.services = services;
	}

	public String getServices(){
		return services;
	}

	public void setTechnologies(Technologies technologies){
		this.technologies = technologies;
	}

	public Technologies getTechnologies(){
		return technologies;
	}

	public void setFeedback(Feedback feedback){
		this.feedback = feedback;
	}

	public Feedback getFeedback(){
		return feedback;
	}

	public void setPartnerships(List<Partnership> partnerships){
		this.partnerships = partnerships;
	}

	public List<Partnership> getPartnerships(){
		return partnerships;
	}

	public void setCompliance(Compliance compliance){
		this.compliance = compliance;
	}

	public Compliance getCompliance(){
		return compliance;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setDepartments(List<Department> departments){
		this.departments = departments;
	}

	public List<Department> getDepartments(){
		return departments;
	}

	public void setAnnouncements(Announcements announcements){
		this.announcements = announcements;
	}

	public Announcements getAnnouncements(){
		return announcements;
	}
}