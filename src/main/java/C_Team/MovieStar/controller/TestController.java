package C_Team.MovieStar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
    @GetMapping("/movieView")
    public String moiveView(){
        return "movieView";
    }
}
