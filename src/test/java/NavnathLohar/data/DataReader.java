package NavnathLohar.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.jar.asm.TypeReference;

public class DataReader {
	
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//NavnathLohar//data//StandAlone.json"),
				StandardCharsets.UTF_8);
	
	
	//String hashmap jackson databind
		
		ObjectMapper mapper=new ObjectMapper();
		
	List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	});
		return data;
		
		
		
		

	}}
