package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.ApiMovieDto;
import C_Team.MovieStar.entity.CommentEntity;
import C_Team.MovieStar.service.ApiService;
import C_Team.MovieStar.service.CommentService;
import C_Team.MovieStar.service.StarService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;
    private final CommentService commentService;
    private final StarService starService;


    @PostMapping("/test")
    public String ApiTest(Model model , String movieTitle) throws ParseException {
        List<ApiMovieDto> findMovieList = apiService.ApitTest(movieTitle);
        System.out.println(findMovieList);
        model.addAttribute("movieList",findMovieList);
        return "apiMovieMain" ;
    }

    @PostMapping("/tmdbTest")
    public String tmdb(Model model, String movieTitle) throws IOException, ParseException {
        List<ApiMovieDto> findMovieList = apiService.getMoviesFromTmdb(movieTitle);
        model.addAttribute("movieList", findMovieList);
        return "apiMovieMain";
    }

    @GetMapping("/view/{id}")
    public String movieViewApi(@PathVariable("id") Long id,Model model) throws IOException, ParseException {
        ApiMovieDto dto = apiService.apiMovieView(id);
        List<CommentEntity> commentEntityList = commentService.findAllComment(id.intValue());
        int starCount = starService.starSum(id.intValue());
        float starAvg = starService.starAvg(id.intValue());
        model.addAttribute("movie", dto);
        model.addAttribute("commentlist",commentEntityList);
        model.addAttribute("starcount", starCount);
        model.addAttribute("starAvg", starAvg);
        return "movieView";
    }
}
