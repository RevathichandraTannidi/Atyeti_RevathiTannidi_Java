package org.example.jsontopojo;

import java.util.List;

public class Cloud{
	private String provider;
	private List<String> services;

	public void setProvider(String provider){
		this.provider = provider;
	}

	public String getProvider(){
		return provider;
	}

	public void setServices(List<String> services){
		this.services = services;
	}

	public List<String> getServices(){
		return services;
	}
}