package C_Team.MovieStar.entity;
import jakarta.persistence.*;

@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int COMMENT_CODE;

    @Column
    private int USER_CODE;

    @Column
    private int MOVIE_CODE;

    @Column
    private String Comment_Content;
}
