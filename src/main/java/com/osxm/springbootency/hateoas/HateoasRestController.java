/**  
* @Title: HateoasRestController.java
* @Package com.osxm.springbootency.hateoas
* @Description: TODO
* @author XM
* @date 2021年12月28日 下午9:43:22
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/hateoas")
public class HateoasRestController {
	
    @GetMapping("/usrs")
    public EntityModel<Usr> getUsr() {
        Usr usr = new Usr("oscar");
        return usr;
    }
    
    @GetMapping("/usrs2")
    public EntityModel<Usr> getUsr2() {
        Usr usr = new Usr("oscar");
        usr.add(linkTo(methodOn(HateoasRestController.class).getUsr()).withSelfRel());
        return usr;
    }
}
