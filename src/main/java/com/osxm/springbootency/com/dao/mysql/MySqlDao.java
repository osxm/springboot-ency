/**  
* @Title: MySqlDao.java
* @Package com.osxm.springbootency.com.dao.mysql
* @Description: TODO
* @author XM
* @date 2021年9月22日 下午10:34:05
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com.dao.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osxm.springbootency.com.entity.Usr;

/**
 * @ClassName MySqlDao
 * @Description TODO
 * @author XM 
 * @date 2021年9月22日
 * 
 */
public interface MySqlDao extends JpaRepository<Usr,Integer>{

}
