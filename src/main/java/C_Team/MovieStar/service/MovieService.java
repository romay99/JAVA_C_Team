package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.MovieDto;
import C_Team.MovieStar.entity.MovieEntity;
import C_Team.MovieStar.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieDto uploadMovie(MovieDto dto) {
        String projectFilePath = System.getProperty("user.dir");
        System.out.println(projectFilePath);
        String saveUrl = "\\src\\main\\resources\\static\\images"; // 파일 저장 경로
        File savePoster = new File(projectFilePath+ saveUrl + "\\" + dto.getFileNewName()+".jpg");

        try {
            dto.getPoster().transferTo(savePoster);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MovieEntity entity = MovieEntity.builder()
                .title(dto.getTitle())
                .moviePosterUrl("/images/"+dto.getFileNewName()+".jpg")
                .synopsis(dto.getSynopsis())
                .build();
        movieRepository.save(entity);
        return dto;
    }

    public List<MovieEntity> showAllMovie(){

        return movieRepository.findAll();
    }

    public Optional<MovieEntity> findMovieById(int id){

        return movieRepository.findById(id);
    }


}
