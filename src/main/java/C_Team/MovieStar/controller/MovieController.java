package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.ApiMovieDto;
import C_Team.MovieStar.dto.MovieDto;
import C_Team.MovieStar.entity.MovieEntity;
import C_Team.MovieStar.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/main") // 메인페이지
    public String showAllMovie(Model model){
        List<MovieEntity> movieList = movieService.showAllMovie();
        model.addAttribute("movieList",movieList);
        return "main";
    }


    @GetMapping("/view/{id}") // 영화 상세페이지
    public String movieViewPage(@PathVariable int id,Model model){
        MovieEntity entity= movieService.findMovieById(id).get();
        model.addAttribute("movie", entity);
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
