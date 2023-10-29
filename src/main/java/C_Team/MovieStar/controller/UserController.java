package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.UserDto;
import C_Team.MovieStar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup") // 회원가입 메서드
    public String signUp(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return "test";
    }
}
