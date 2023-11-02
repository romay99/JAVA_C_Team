package C_Team.MovieStar.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@ToString
@Getter
public class MovieEntity {
    @Id
    @Column(name = "movie_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieCode;

    // TODO 나중에 포스터주소 변수 추가해야됨

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "movie_sysnopsis")
    private String movieSysnopsis;

    @Builder
    public MovieEntity(String title,String sysnop){
        this.movieTitle = title;
        this.movieSysnopsis = sysnop;
    }

}
