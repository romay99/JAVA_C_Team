package C_Team.MovieStar.entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CommentEntity {

    @Id
    @Column(name = "comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentCode;

    @Column(name = "user_id")
    private String writer;

    @Column(name = "movie_code")
    private int movieCode;

    @Column(name = "comment_content")
    private String commentContent;

    @Builder
    public CommentEntity(String writer, int movieCode, String commentContent) {
        this.writer = writer;
        this.movieCode = movieCode;
        this.commentContent = commentContent;
    }
}
