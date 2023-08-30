/**  
* @Title: DirectController.java
* @Package com.osxm.springbootency.extjs
* @Description: TODO
* @author XM
* @date 2023年8月29日 下午10:34:36
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.extjs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DirectController
 * @Description TODO
 * @author XM 
 * @date 2023年8月29日
 * 
 */
@RestController
@CrossOrigin(origins = "*")
public class DirectController {

	/**
	 * 
	 * @param requestMap  {"action":"MyAction","method":"hello","data":["osxm"],"type":"rpc","tid":1}
	 * @return
	 *  {"type":"rpc","tid":1,"action":"MyAction","method":"hello","result":"Hello,osxm"},
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/direct/hello")
	public Map<String, Object> hello(@RequestBody Map<String, Object> requestMap) {
		List<String> data = (List<String>) requestMap.get("data");
		String result = "Hello," + data.get(0);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("type", requestMap.get("type"));
		responseMap.put("tid", requestMap.get("tid"));
		responseMap.put("action", requestMap.get("action"));
		responseMap.put("method", requestMap.get("method"));
		responseMap.put("result", result);
		return responseMap;

	}
}
