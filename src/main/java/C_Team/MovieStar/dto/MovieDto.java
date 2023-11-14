package C_Team.MovieStar.dto;

import C_Team.MovieStar.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
@ToString
public class MovieDto {

    private String title;
    private MultipartFile poster;
    private String synopsis;
    private String fileOriginalName;
    private String fileNewName;

    public MovieDto(){
        this.fileNewName = UUID.randomUUID().toString();
    }

}
