package com.tukjax.cargo.boot.facade;

import com.tukjax.cargo.boot.dao.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping("/mybatis/example1")
public class ExampleFacade {


    @Autowired
    BookRepo bookRepo;

    @GetMapping("/ex_1")
    public String example(){

        bookRepo.selectBatchIds(Arrays.asList(1,2,3,4,5,6,7,8,9,0,111));
        return "ok";

    }

}
