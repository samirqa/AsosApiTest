package data;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

public class search_dp
{
	@DataProvider
	public SearchProduct[] testsearch_dp()
	{
		String s = null;
		try {
				s =FileUtils.readFileToString(new File(getClass().getResource("searchproduct.json").getFile()), "UTF-8");
			//	s =FileUtils.readFileToString(new File("src/test/resources/requestjsonfile/searchproduct.json"), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		SearchProduct results[]=null;
		try {
			results = mapper.readValue(s, SearchProduct[].class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
		
	}
}

