package C_Team.MovieStar.entity;

import jakarta.persistence.*;

@Entity
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

}
