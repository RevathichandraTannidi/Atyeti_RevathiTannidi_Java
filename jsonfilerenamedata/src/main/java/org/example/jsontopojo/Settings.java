package org.example.jsontopojo;

public class Settings{
	private String theme;
	private Notifications notifications;

	public void setTheme(String theme){
		this.theme = theme;
	}

	public String getTheme(){
		return theme;
	}

	public void setNotifications(Notifications notifications){
		this.notifications = notifications;
	}

	public Notifications getNotifications(){
		return notifications;
	}
}
