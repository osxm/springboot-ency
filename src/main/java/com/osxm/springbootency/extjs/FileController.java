/**
* @Title: FileController.java
* @Package com.osxm.springbootency.extjs
* @Description: TODO
* @author XM
* @date 2023年6月23日 下午8:42:07
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.springbootency.extjs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileController
 * @Description TODO
 * @author XM 
 * @date 2023年6月23日
 * 
 */
@RestController
@RequestMapping("/extjs/files")
public class FileController {

	@PostMapping(value = "/upload",produces = "application/json")
	@CrossOrigin(origins = "*")
	public Map<String,Object> upload(@RequestParam("myfile") MultipartFile myfile) {
		Map<String,Object> rtnMap  = new HashMap<String,Object>();
		
		String uploadFolder= "D://uploads";
		try {
			String fullFileName = myfile.getOriginalFilename();
			String fileName = StringUtils.cleanPath(fullFileName);
			String targetFullFileName = uploadFolder + File.separator+fileName;
			File targetFile = new File(targetFullFileName);
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			InputStream in = myfile.getInputStream();
			FileOutputStream out = new FileOutputStream(targetFile);
			int n = 0;
			byte[] b = new byte[1024];
			while ((n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}
			out.close();
			in.close();
			rtnMap.put("success","true");
			//rtnMap.put("msg",fileName+" upload success.");
		}catch(Exception e) {
			rtnMap.put("success","false");
			//rtnMap.put("msg"," upload fail for "+e.getMessage());		
		}
		return rtnMap;
	}
	
	/*@PostMapping(value = "/upload2",produces = "application/json")
	@CrossOrigin(origins = "*")
	public Map<String,Object> upload2(@RequestParam("myfile") MultipartFile myfile,HttpServletResponse response) {
		response.setStatus(HttpStatus.OK.value());
		Map<String,Object> rtnMap  = new HashMap<String,Object>();
		
		String uploadFolder= "D://uploads";
		try {
			String fullFileName = myfile.getOriginalFilename();
			String fileName = StringUtils.cleanPath(fullFileName);
			String targetFullFileName = uploadFolder + File.separator+fileName;
			File targetFile = new File(targetFullFileName);
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			InputStream in = myfile.getInputStream();
			FileOutputStream out = new FileOutputStream(targetFile);
			int n = 0;
			byte[] b = new byte[1024];
			while ((n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}
			out.close();
			in.close();
			rtnMap.put("success","true");
			//rtnMap.put("msg",fileName+" upload success.");
		}catch(Exception e) {
			rtnMap.put("success","false");
			//rtnMap.put("msg"," upload fail for "+e.getMessage());		
		}
		return rtnMap;
	}*/
}
