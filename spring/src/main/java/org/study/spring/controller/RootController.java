package org.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/root")
public class RootController {

    @GetMapping("/root/aa")
    public String index() {
        return "index";
    }
}
