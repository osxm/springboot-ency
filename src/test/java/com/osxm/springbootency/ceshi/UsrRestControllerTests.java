/**
 * @Title: UsrRestControllerTests.java
 * @Package com.osxm.springbootency.ceshi
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月15日
 * @version V1.0
 */
package com.osxm.springbootency.ceshi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
  * @ClassName: UsrRestControllerTests
  * @Description: TODO
  * @author oscarchen
  */

@SpringBootTest
@AutoConfigureMockMvc
public class UsrRestControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void get() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/ceshi/users/1").characterEncoding("UTF-8")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
