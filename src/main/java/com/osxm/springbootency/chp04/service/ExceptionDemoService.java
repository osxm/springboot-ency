/**
 * @Title: ExceptionDemoService.java
 * @Package com.osxm.springbootency.chp04.service
 * @Description: TODO
 * @author oscarchen
 * @date 2021年7月21日
 * @version V1.0
 */
package com.osxm.springbootency.chp04.service;

import org.springframework.stereotype.Service;

import com.osxm.springbootency.chp04.SbJsonException;
import com.osxm.springbootency.chp04.SbModelViewException;
import com.osxm.springbootency.com.entity.Usr;

/**
 * @ClassName: ExceptionDemoService
 * @Description: TODO
 * @author oscarchen
 */
@Service
public class ExceptionDemoService {

	public void throwSbModelViewException() {
		throw new SbModelViewException();
	}

	public void throwJsonException() {
		throw new SbJsonException();
	}
	
	public void throwNullExp() {
		Usr usr = null;
		String name = usr.getName();
	}
}
