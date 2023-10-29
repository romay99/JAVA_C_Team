package C_Team.MovieStar.controller;

import C_Team.MovieStar.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
}
