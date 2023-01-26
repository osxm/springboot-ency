/**  
* @Title: TreeController.java
* @Package com.osxm.springbootency.extjs
* @Description: TODO
* @author XM
* @date 2022年10月9日 下午9:47:18
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.extjs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tree")
public class TreeController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/getdata" ,produces="application/json")
	public List<Node> getNodeData(@RequestParam String node) {
		List<Node> countryList = Arrays.asList(new Node("country-001", "魏"), new Node("country-002", "蜀"),
				new Node("country-003", "吴"));
		List<Node> country001GeneralList = Arrays.asList(new Node("general-001", "曹操"), new Node("general-002", "徐晃"),
				new Node("general-003", "夏侯渊"));
		List<Node> country002GeneralList = Arrays.asList(new Node("general-004", "刘备"), new Node("general-005", "关羽"),
				new Node("general-006", "张飞"));
		List<Node> country003GeneralList = Arrays.asList(new Node("general-007", "孙权"), new Node("general-008", "吕蒙"),
				new Node("general-009", "黄盖"));
		List<Node> general001CityList = Arrays.asList(new Node("city-001", "许昌"), new Node("city-002", "洛阳"),
				new Node("city-003", "邺城"),new Node("city-004", "洛阳"));
		List<Node> general004CityList = Arrays.asList(new Node("city-005", "成都"), new Node("city-006", "荆州"),
				new Node("city-007", "益州"),new Node("city-008", "建宁"));	
		List<Node> general007CityList = Arrays.asList(new Node("city-009", "武昌"), new Node("city-002", "建业"),
				new Node("city-003", "吴郡"),new Node("city-003", "秣陵"));	
				
		List<Node> childList = new ArrayList<Node>();
		switch (node) {
		case "root":
			childList = countryList;
			childList.get(0).setExpanded(true);
			break;
		case "country-001":
			childList = country001GeneralList;
			childList.get(0).setExpanded(true);
			break;
		case "country-002":
			childList = country002GeneralList;
			break;
		case "country-003":
			childList = country003GeneralList;
			break;
		case "general-001":
			childList = general001CityList;
			break;
		case "general-004":
			childList = general004CityList;
			break;
		case "general-007":
			childList = general007CityList;
			break;			
		default:
			break;
		}
		return childList;
	}

}
