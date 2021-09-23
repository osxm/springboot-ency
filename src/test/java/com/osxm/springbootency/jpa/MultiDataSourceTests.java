/**  
* @Title: MultiDataSourceTests.java
* @Package com.osxm.springbootency.jpa
* @Description: TODO
* @author XM
* @date 2021年9月23日 下午10:00:08
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osxm.springbootency.com.dao.mysql.MySqlRepository;
import com.osxm.springbootency.com.dao.oracle.OracleRepository;

/**
 * @ClassName MultiDataSourceTests
 * @Description TODO
 * @author XM 
 * @date 2021年9月23日
 * 
 */

@SpringBootTest
public class MultiDataSourceTests {
	
	@Autowired
	private MySqlRepository mysqlDao;
	
	@Autowired
	private OracleRepository oracleDao;
	
	@Test
	public void mysqlQuery() {
		String result = mysqlDao.queryList().toString();
		System.out.print(result);
	}

}
