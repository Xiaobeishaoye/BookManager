package book.manager.controller;


import book.manager.service.SimpleSevice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Controller
public class PageController {

    @Resource
    SimpleSevice simpleSevice;

    @RequestMapping("/admin")
    public String admin(){
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
