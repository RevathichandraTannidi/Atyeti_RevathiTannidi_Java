package org.example.jsontopojo;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "company", "location", "departments", "projects" })
public class PArent {
    private String company;
    private Location location;
    private List<Department> departments;
    private int founded;
    private boolean active;
    private Technologies technologies;
    private List<Project> projects;
    private Compliance compliance;
    private Map<String, Map<String, Double>> feedback;
    private List<Partnership> partnerships;
    private Announcements announcements;
    private Settings settings;


    private String country;
    private String services;

    // Getters & setters for all fields

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public int getFounded() { return founded; }
    public void setFounded(int founded) { this.founded = founded; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Technologies getTechnologies() { return technologies; }
    public void setTechnologies(Technologies technologies) { this.technologies = technologies; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    public Compliance getCompliance() { return compliance; }
    public void setCompliance(Compliance compliance) { this.compliance = compliance; }

    public Map<String, Map<String, Double>> getFeedback() { return feedback; }
    public void setFeedback(Map<String, Map<String, Double>> feedback) { this.feedback = feedback; }

    public List<Partnership> getPartnerships() { return partnerships; }
    public void setPartnerships(List<Partnership> partnerships) { this.partnerships = partnerships; }

    public Announcements getAnnouncements() { return announcements; }
    public void setAnnouncements(Announcements announcements) { this.announcements = announcements; }

    public Settings getSettings() { return settings; }
    public void setSettings(Settings settings) { this.settings = settings; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }
}



//Jackson serializes Java objects back into JSON, but the order of keys/fields may not exactly match the original JSON file.
//
//The JSON structure (nested objects, arrays) will be preserved.
//
//The exact order of keys in JSON objects is not guaranteed because JSON objects are unordered by definition.
//
//If you want pretty-printed JSON, Jackson can do that with indentation.

