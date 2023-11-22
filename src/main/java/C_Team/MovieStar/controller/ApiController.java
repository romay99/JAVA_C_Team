package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.ApiMovieDto;
import C_Team.MovieStar.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;


    @PostMapping("/test")
    public String ApiTest(Model model , String movieTitle) throws ParseException {
        List<ApiMovieDto> findMovieList = apiService.ApitTest(movieTitle);
        System.out.println(findMovieList);
        model.addAttribute("movieList",findMovieList);
        return "apiMovieMain" ;
    }
}
