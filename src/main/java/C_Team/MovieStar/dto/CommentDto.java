package C_Team.MovieStar.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDto {
    public String contents;
    public String writer;
    public int movieCode;
}
