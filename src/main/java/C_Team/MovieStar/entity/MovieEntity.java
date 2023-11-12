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

    @Column(name = "movie_poster")
    private String moviePosterUrl;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "movie_sysnopsis")
    private String movieSysnopsis;

    @Builder
    public MovieEntity(String title,String sysnop,String moviePosterUrl){
        this.movieTitle = title;
        this.movieSysnopsis = sysnop;
        this.moviePosterUrl = moviePosterUrl;
    }

}
