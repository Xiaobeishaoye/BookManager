package book.manager.controller;


import book.manager.service.SimpleSevice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

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
        new Thread(() -> {   //创建一个子线程去获取
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            User user = (User) authentication.getPrincipal();   //NPE
            System.out.println(user.getUsername());
            System.out.println(user.getAuthorities());
        }).start();
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/auth")
    @ResponseBody
    public String auth(){
        SecurityContext context = SecurityContextHolder.getContext();  //获取SecurityContext对象（当前会话肯定是没有登陆的）
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("Test", null,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_user"));  //手动创建一个UsernamePasswordAuthenticationToken对象，也就是用户的认证信息，角色需要添加ROLE_前缀，权限直接写
        context.setAuthentication(token);  //手动为SecurityContext设定认证信息
        return "Login success！";
    }

}
