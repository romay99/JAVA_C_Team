package C_Team.MovieStar.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class MovieEntity {
    @Id
    @Column(name = "movie_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MovieCode;

    // TODO 나중에 포스터주소 변수 추가해야됨

    @Column(name = "movie_title")
    private String MovieTitle;

    @Column(name = "movie_sysnopsis")
    private String MovieSysnopsis;

    @Builder
    public MovieEntity(String title,String sysnop){
        this.MovieTitle = title;
        this.MovieSysnopsis = sysnop;
    }

}
