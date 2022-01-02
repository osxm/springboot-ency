package com.osxm.springbootency.jpa;



import org.springframework.data.jpa.domain.Specification;

import com.osxm.springbootency.com.entity.Usr;

public class UsrSpecifications {
	
	public static Specification<Usr> nameLike(String pattern) {
        return (r, q, b) -> b.like(r.get("name"), pattern);
    }
}
