
package org.example.gamedemo.controller;

import org.example.gamedemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
public class BasicController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
