package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.MovieDto;
import C_Team.MovieStar.entity.MovieEntity;
import C_Team.MovieStar.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieDto uploadMovie(MovieDto dto) {
        MovieEntity entity = dto.toEntity(dto);
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
