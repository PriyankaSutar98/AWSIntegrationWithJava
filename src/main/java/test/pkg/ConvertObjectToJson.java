package test.pkg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.pojo.Employee;

public class ConvertObjectToJson {
	
	public static void main(String args[]) throws JsonProcessingException{
		Employee e= new Employee();
		e.setId("1l");
		e.setAddress("Sandy");
		e.setName("Jon");
		
		ObjectMapper mapper=new ObjectMapper();
		String jemp=mapper.writeValueAsString(e);
		
		System.out.println(jemp);
		
	}

}
