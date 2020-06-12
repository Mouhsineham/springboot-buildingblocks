package com.stacksimplify.restservices.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

   @GetMapping("/")
    public  String helloWorld(){

        return  "my mknch assast";
    }
}
