package com.lms.studentController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lms/v1/student")
public class StudentController {

    @GetMapping("/hello")
   String helloStudent(){
        return "Hello Dear Student";
    }

}
