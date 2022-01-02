/**  
* @Title: Usr.java
* @Package com.osxm.springbootency.hateoas
* @Description: TODO
* @author XM
* @date 2021年12月28日 下午9:41:11
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class Usr extends EntityModel<Usr>{
    
    private String name;
    

    public Usr(String name) {
        this.name = name;
        //add(Link.of("http://localhost:8080/usrs"));
    }


    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

}