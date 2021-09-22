/**  
* @Title: OracleDao.java
* @Package com.osxm.springbootency.com.dao.oracle
* @Description: TODO
* @author XM
* @date 2021年9月22日 下午10:36:33
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com.dao.oracle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osxm.springbootency.com.entity.Usr;

/**
 * @ClassName OracleDao
 * @Description TODO
 * @author XM 
 * @date 2021年9月22日
 * 
 */
public interface OracleDao extends JpaRepository<Usr,Integer> {

}
