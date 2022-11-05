package springboot_base.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getByid(){
        System.out.println("Springboot-ControllerPackage is running ...");
        return "Springboot BookController.java";
    }
}
