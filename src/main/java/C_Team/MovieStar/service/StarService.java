package C_Team.MovieStar.service;

import C_Team.MovieStar.entity.StarEntity;
import C_Team.MovieStar.repository.StarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StarService {
    private final StarRepository starRepository;

    public String giveStarToMovie(int movieCode,int userCode,float starCount){

        StarEntity entity = StarEntity.builder()
                .starCount(starCount)
                .movieCode(movieCode)
                .userCode(userCode)
                .build();


        starRepository.save(entity);
        return "";
    }

    public int starSum(int movieCode){
        return starRepository.countByMovieCode(movieCode);
    }

    public float starAvg(int movieCode) {
        if(starRepository.findAvgStarCountByMovieCode(movieCode) == null){
            return 0;
        }
        float starCount = (float) Math.round(starRepository.findAvgStarCountByMovieCode(movieCode) * 10) / 10;

        return starCount;
    }
}
