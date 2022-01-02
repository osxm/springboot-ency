package com.osxm.springbootency.jpa;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.osxm.springbootency.com.entity.Usr;

@Repository
public interface UsrRepository  extends CrudRepository<Usr, Long>, JpaSpecificationExecutor<Usr>{

}
