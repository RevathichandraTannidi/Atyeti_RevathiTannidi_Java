package org.example.jsontopojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Compliance {
	private boolean iso27001;
	private SOC2 soc2;
}

