package com.stacksimplify.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWordController {


   @GetMapping("/")
    public  String helloWorld(){
       return new personne("jalil", "kahlil", "0604539542","casa").toString();
    }
}
