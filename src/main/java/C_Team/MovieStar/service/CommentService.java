package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.CommentDto;
import C_Team.MovieStar.entity.CommentEntity;
import C_Team.MovieStar.repository.CommentRepository;
import C_Team.MovieStar.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;


    // 댓글 작성 메서드
    public CommentDto postComment(CommentDto dto){
        CommentEntity entity = CommentEntity.builder()
                .writer(dto.writer)
                .commentContent(dto.contents)
                .movieCode(dto.movieCode)
                .build();

        commentRepository.save(entity);
        return dto;
    }

}
