package C_Team.MovieStar.dto;

import C_Team.MovieStar.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    public String Title;
    public String Sysnopsis;

    public MovieEntity toEntity(MovieDto dto){
        return MovieEntity.builder()
                .title(dto.getTitle())
                .sysnop(dto.getSysnopsis())
                .build();
    }
}