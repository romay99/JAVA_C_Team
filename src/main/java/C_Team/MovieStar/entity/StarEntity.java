package C_Team.MovieStar.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class StarEntity {
    @Id
    @Column(name = "star_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int starCode;
    @Column(name = "user_code")
    private int userCode;
    @Column(name = "movie_code")
    private int movieCode;
    @Column(name = "star_count")
    private int starCount;

    @Builder
    public StarEntity(int userCode, int movieCode, int starCount) {
        this.userCode = userCode;
        this.movieCode = movieCode;
        this.starCount = starCount;
    }
}
