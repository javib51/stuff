package org.javib51.jackson.aggregation;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
/**
 * Hello world!
 *
 */
public class App 
{
    	public static void main( String[] args )
    	{
		ObjectMapper mapper = new ObjectMapper();	
		//mapper.setSerializationInclusion(Include.NON_NULL);
		//mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		//mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Sample2 s1 = new Sample2("Javi");
		Sample s2 = new Sample("Perez", s1);
		String aux;
		try {
		
			System.out.println("Java to JSON: Simple serialization: " + mapper.writeValueAsString(s1));
			System.out.println("Java to JSON: Aggregation: " + mapper.writeValueAsString(s2));
			System.out.println("JSON to Java: Simple serialization: " + mapper.readValue("{\"name\":\"Jorge\"}", Sample2.class).toString());
			System.out.println("JSON to Java: Aggregation: " + mapper.readValue("{\"name\":\"Pepe\",\"sample\":{\"name\":\"Manuel\"}}", Sample.class).toString());
		} catch(Exception e) {
			e.printStackTrace();	
		}
    	}
}
