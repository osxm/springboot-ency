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

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osxm.springbootency.com.entity.mysql.Usr;



/**
 * @ClassName MySqlDao
 * @Description TODO
 * @author XM 
 * @date 2021年9月22日
 * 
 */
@Profile("withdb")
@Repository
public interface MySqlRepository extends JpaRepository<Usr,Integer>{

	@Query(value = "SELECT p FROM USR p")
    List<Usr> queryList();
}
