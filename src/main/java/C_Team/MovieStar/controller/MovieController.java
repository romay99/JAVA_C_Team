package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.MovieDto;
import C_Team.MovieStar.entity.MovieEntity;
import C_Team.MovieStar.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/allMovie") // 모든 영화 조회
    public String showAllMovie(Model model){
        List<MovieEntity> movieList = movieService.showAllMovie();
        model.addAttribute("movieList",movieList);
        return "main";
    }

    @PostMapping("/upload")  // 영호 업로드
    public String uploadMovie(@RequestBody MovieDto dto){
        movieService.uploadMovie(dto);
        return "main";
    }
}
