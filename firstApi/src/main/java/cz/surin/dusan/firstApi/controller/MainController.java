package cz.surin.dusan.firstApi.controller;

import cz.surin.dusan.firstApi.response.User;
import org.springframework.web.bind.annotation.*;

@RestController("/hello")
public class MainController {

    //localhost:8080/hello
    // Hello world!
    @GetMapping("hello")
    public String hello() {
        return "Hello world!";

    //localhost:8080/hello/John
    // Hello John!
    }
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    //http://localhost:8080/hello-with-name?name=Dusan&surname=Surin&age=32
    // Hello Dusan Surin!
    @GetMapping("/hello-with-name")
    public String hello(@RequestParam(value ="name", required = false) String name,
                        @RequestParam (value ="surname", required = false)String surname) {
        return "Hello " + name + " " + surname + "!";
    }
    //http://localhost:8080/hello-int
    // 13
    @GetMapping("/hello-int")
    public int helloInt() {
        return 13;
    }

    //http://localhost:8080/hello-user?name=Dusan&surname=Surin&age=32
    // {"name":"Dusan","surname":"Surin","age":32}
    @GetMapping("/hello-user")
    public User helloUser(
        @RequestParam (value ="name", required = false) String name,
        @RequestParam (value ="surname", required = false)String surname,
      @RequestParam (value = "age", required = false, defaultValue = "13") int age){
        return new User(name, surname, age);

    }
}
