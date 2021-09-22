/**
 * @Title: OracleLobTests.java
 * @Package com.osxm.springbootency.jpa
 * @Description: TODO
 * @author oscarchen
 * @date 2021年6月24日
 * @version V1.0
 */
package com.osxm.springbootency.jpa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.ClassUtils;

/**
 * @ClassName: OracleLobTests
 * @Description: TODO
 * @author oscarchen
 */
@SpringBootTest
@Transactional
@Rollback(false)
public class OracleLobTests {

	@Autowired
	private EntityManager em;

	//@Test
	public void add() throws Exception {
		// 转换图片文件为字节数组
		// D:/demoworkspace/springboot-ency/target/test-classes/
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		InputStream ins = new FileInputStream(path + "../classes/static/images/spring.jpg");
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = ins.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.flush();
		byte data[] = bos.toByteArray();
		ins.close();
		
		SbImage sb = new SbImage();
		sb.setName("Spring");
		sb.setContent(data);
		sb.setRemark("Spring图书......");
		em.persist(sb);
	}
	
	@Test
	public void query() throws Exception{
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		
		SbImage sbImage = em.createQuery("from SbImage where name=:name", SbImage.class).setParameter("name", "Spring").getSingleResult();
		byte[] content = sbImage.getContent();
		OutputStream out = new FileOutputStream("D://temp/spring.jpg"); 
		out.write(content);
		out.close();
		System.out.println(sbImage.getContent());
	}

}
