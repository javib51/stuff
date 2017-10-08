package org.javib51.jackson.aggregation;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SampleDeserialize extends StdDeserializer<Sample> {
	
	public SampleDeserialize() {
		this(null);
	}

	public SampleDeserialize(Class<?> vclass) {
		super(vclass);
	}

	@Override
	public Sample deserialize(JsonParser parser, 
			DeserializationContext context) 
		throws IOException, JsonProcessingException{
		
		JsonNode node = parser.getCodec().readTree(parser);
		
		String name = node.get("name").asText();
		String name2 = node.get("sample").get("name").asText();
		
		return new Sample(name, new Sample2(name2));
	
	}

}

