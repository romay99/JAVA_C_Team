package C_Team.MovieStar.entity;

import jakarta.persistence.*;

@Entity
public class StarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int STAR_CODE;
    @Column
    private int USER_CODE;
    @Column
    private int MOVIE_CODE;
    @Column
    private int Star_Count;

}
