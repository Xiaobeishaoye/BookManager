package book.manager.controller;


import book.manager.entity.AuthUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(@SessionAttribute("user") AuthUser user, Model model){
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

}
