package C_Team.MovieStar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiMovieDto {
    public String title;
    public String synopsis;
    public String posterUrl;
    public Long movieId;
    public String releaseDate;

    @Builder
    public ApiMovieDto(String title, String synopsis, String posterUrl,Long movieId,String date) {
        this.title = title;
        this.synopsis = synopsis;
        this.posterUrl = posterUrl;
        this.movieId = movieId;
        this.releaseDate = date;
    }
}
