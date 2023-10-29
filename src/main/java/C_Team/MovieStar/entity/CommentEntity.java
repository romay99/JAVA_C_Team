package C_Team.MovieStar.entity;
import jakarta.persistence.*;

@Entity
public class CommentEntity {

    @Id
    @Column(name = "comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CommentCode;

    @Column(name = "user_code")
    private int UserCode;

    @Column(name = "movie_code")
    private int MovieCode;

    @Column(name = "comment_content")
    private String CommentContent;
}
