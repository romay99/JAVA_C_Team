package C_Team.MovieStar.repository;

import C_Team.MovieStar.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {

    List<CommentEntity> findAllByMovieCode(int movieCode);
}
