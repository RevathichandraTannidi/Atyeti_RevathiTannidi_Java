package org.example.jsontopojo;

public class Push{
	private boolean enabled;
	private String frequency;

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setFrequency(String frequency){
		this.frequency = frequency;
	}

	public String getFrequency(){
		return frequency;
	}
}
