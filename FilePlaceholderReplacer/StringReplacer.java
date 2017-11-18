package bg.uni.sofia.fmi.mjt.streams;

import java.util.Map;

public class StringReplacer {
	
	private String input;


	public StringReplacer(String input) {
        this.input = input;
    }
    
    public String replace(Map<String, String> map) {
    	String result = input;
    	
    	for (Map.Entry<String, String> entry : map.entrySet()) {
    		result = result.replace('{' + entry.getKey() + '}', entry.getValue());
    		//result+="\n";
		}
    	
		return result;
        
        // TODO implement me
    }
}
