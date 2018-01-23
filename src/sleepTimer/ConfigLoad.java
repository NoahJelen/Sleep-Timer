package sleepTimer;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class ConfigLoad {
	@SuppressWarnings("unchecked")
	public static long[] readJson(String file) {
        JSONParser parser = new JSONParser();
        long[] options = {0,0,0,0};

        try {
            FileReader fileReader = new FileReader(file);
            JSONObject json = (JSONObject) parser.parse(fileReader);

            long shutdownhr = (long) json.get("shutdownhr");
            long shutdownmin = (long) json.get("shutdownmin");
            long remindhr = (long) json.get("remindhr");
            long remindmin = (long) json.get("remindmin");

	        options[0] =shutdownhr;
	        options[1]=shutdownmin;
	        options[2]=remindhr;
	        options[3]=remindmin;
            return options;
        } 
        catch (Exception ex) {	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("shutdownhr", 23);
			jsonObject.put("shutdownmin", 0);
			jsonObject.put("remindhr", 22);
			jsonObject.put("remindmin", 50);
	        options[0] =23;
	        options[1]=0;
	        options[2]=22;
	        options[3]=50;
			try {
				@SuppressWarnings("resource")
				FileWriter fileWriter = new FileWriter("config.json");
				fileWriter.write(jsonObject.toJSONString());
				fileWriter.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
        }
		return options;
    }
}