package C_Team.MovieStar.repository;

import C_Team.MovieStar.entity.StarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<StarEntity,Integer> {
    int countByMovieCode(int movieCode);

    @Query("SELECT AVG(s.starCount) FROM StarEntity s WHERE s.movieCode = :movieCode")
    Float findAvgStarCountByMovieCode(@Param("movieCode") int movieCode);

}
