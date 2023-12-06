package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.StarDto;
import C_Team.MovieStar.service.StarService;
import C_Team.MovieStar.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/star")
@RequiredArgsConstructor
public class StarController {

    private final StarService starService;
    private final UserService userService;

    @PostMapping("/givestar")
    public String giveStar(HttpServletRequest request, StarDto starDto){
        HttpSession session = request.getSession(false);
        String id = session.getAttribute("userId").toString();
        int userCode = userService.findUserById(id);

        float starCount = starDto.getStarCount();
        int movieCode = starDto.getMovieCode();


        starService.giveStarToMovie(movieCode,userCode,starCount);

        return "apiMovieMain";
    }
}
