package C_Team.MovieStar.controller;

import C_Team.MovieStar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @PostMapping("/delete/{userCode}")
    public String deleteUser(@PathVariable("userCode")int userCode ){
        if(userCode != 1){
        userService.deleteUser(userCode);
        }
        System.out.println("userCode = " + userCode);
        return "redirect:/movie/main";
    }
}
