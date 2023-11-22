package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.UserDto;
import C_Team.MovieStar.dto.UserLoginDto;
import C_Team.MovieStar.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup") // 회원가입 페이지로 이동하는 메서드
    public String signUpPage() {
        return "signUpPage";
    }


    @PostMapping("/signup") // 회원가입 메서드
    public String signUp(UserDto userDto) {
        System.out.println("userDto = " + userDto);
        userService.createUser(userDto);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> loginUser(UserLoginDto userDto, HttpServletRequest request, HttpServletResponse response){
        if (userService.loginUser(userDto)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userDto.getUserId());
            System.out.println("유저 ID = " + userDto.getUserId() + " 로그인 성공");
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/movie/main").body("로그인 성공!");
        }
        System.out.println("유저 정보  = " + userDto + " 잘못된 로그인 ");
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/user/login").body("잘못된 로그인입니다.");
    }

    @GetMapping("/logout")
    public String logOutUser(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/user/login";
    }

    @PostMapping("/idCheck")
    public void userIdExist(String userId,Model model){
        if(userService.userIdCheck(userId)){
            model.addAttribute("status",400);
        }
        model.addAttribute("status",200);
    }
}
