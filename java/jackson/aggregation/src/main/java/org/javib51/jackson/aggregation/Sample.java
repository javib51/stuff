package org.javib51.jackson.aggregation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize; 

@JsonDeserialize(using = SampleDeserialize.class)
public class Sample implements java.io.Serializable {

	private String name;
	private Sample2 sample;

	Sample() {}

	Sample(String name, Sample2 sample) {
		this.name = name;
		this.sample = sample;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSample(Sample2 name) {
		this.sample = sample;
	}

	public Sample2 getSample() {
		return sample;
	}
	
	@Override
	public String toString() {
		return "{\"name\":\"" + name + ", \"sample\":\"" + sample + "}";
	}

}
