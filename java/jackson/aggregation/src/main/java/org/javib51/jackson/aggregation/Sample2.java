package org.javib51.jackson.aggregation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sample2 implements java.io.Serializable {

	private String name;

	Sample2() {}

	Sample2(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "{ \"name\": \"" + name + "\"}";
	}

}
