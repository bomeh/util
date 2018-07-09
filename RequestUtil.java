package shopping.cmmn;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

	public static Map<String, Object> RequestToMap(HttpServletRequest request) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		Enumeration<String> enumeration = request.getParameterNames();
		
		while(enumeration.hasMoreElements()) {
			
			String key = enumeration.nextElement();
			
			if(key.toLowerCase().indexOf("array") == -1) {
				
				paramMap.put(key, request.getParameter(key));
			} else {
				
				String array[] = request.getParameterValues(key);
				
				paramMap.put(key, ArrayUtil.getArray(array));
			}
			
			
		}
		
		
		
		return paramMap;
	}
}
