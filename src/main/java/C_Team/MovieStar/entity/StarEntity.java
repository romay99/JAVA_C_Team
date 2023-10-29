package C_Team.MovieStar.entity;

import jakarta.persistence.*;

@Entity
public class StarEntity {
    @Id
    @Column(name = "star_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StarCode;
    @Column(name = "user_code")
    private int UserCode;
    @Column(name = "movie_code")
    private int MovieCode;
    @Column(name = "star_count")
    private int StarCount;

}
