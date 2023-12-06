package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.ApiMovieDto;
import C_Team.MovieStar.dto.MovieDto;
import C_Team.MovieStar.entity.CommentEntity;
import C_Team.MovieStar.entity.MovieEntity;
import C_Team.MovieStar.service.ApiService;
import C_Team.MovieStar.service.CommentService;
import C_Team.MovieStar.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final CommentService commentService;
    private final ApiService apiService;

    @GetMapping("/main") // 메인페이지
    public String showAllMovie(Model model) throws IOException, ParseException {
        List<ApiMovieDto> apiMovieDtoList = apiService.popularMovie();
        model.addAttribute("movieList",apiMovieDtoList);
        System.out.println("apiMovieDtoList = " + apiMovieDtoList);
        return "searchMain";
    }


    @GetMapping("/view/{id}") // 영화 상세페이지
    public String movieViewPage(@PathVariable int id, Model model){
        MovieEntity entity= movieService.findMovieById(id).get();
        List<CommentEntity> commentEntityList = commentService.findAllComment(id);

        model.addAttribute("movie", entity);
        model.addAttribute("commentlist",commentEntityList);

        return "movieView";
    }

    @GetMapping("/upload") // 영화 업로드 페이지
    public String movieUploadPage(Model model){
        MovieDto dto = new MovieDto();
        model.addAttribute("dto",dto);
        return "movieUploadPage";
    }

    @PostMapping("/upload")  // 영화 업로드
    public String uploadMovie(MovieDto dto){
        System.out.println("dto.getTitle() = " + dto.getTitle());
        System.out.println("dto = " + dto);
        movieService.uploadMovie(dto);
        return "redirect:/movie/main";
    }

    public String showApiMovies(Model model,List<ApiMovieDto> movieList){

        return "main";
    }
}
