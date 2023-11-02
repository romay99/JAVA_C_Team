package C_Team.MovieStar.entity;
import jakarta.persistence.*;

@Entity
public class CommentEntity {

    @Id
    @Column(name = "comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentCode;

    @Column(name = "user_code")
    private int userCode;

    @Column(name = "movie_code")
    private int movieCode;

    @Column(name = "comment_content")
    private String commentContent;
}
