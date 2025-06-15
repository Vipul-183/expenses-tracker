package com.vipul.expense;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControleer {
    @RequestMapping("/")
    public String index() {
        String name = getViewnName();
        return name;
    }

    private String getViewnName() {
        return "index";
    }
 }
