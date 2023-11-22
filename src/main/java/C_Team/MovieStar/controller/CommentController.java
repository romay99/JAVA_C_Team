package C_Team.MovieStar.controller;

import C_Team.MovieStar.dto.CommentDto;
import C_Team.MovieStar.service.CommentService;
import C_Team.MovieStar.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final MovieService movieService;
    private final CommentService commentService;

    @ResponseBody
    @PostMapping("/post")
    public void postComment(CommentDto commentDto){
        System.out.println("commentDto = " + commentDto);
        commentService.postComment(commentDto);

    }
}
