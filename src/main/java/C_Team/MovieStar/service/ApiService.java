package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.ApiMovieDto;
import C_Team.MovieStar.dto.MovieDto;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApiService {

    public List<ApiMovieDto> ApitTest(String movieTitle) throws ParseException {
        System.out.println("movieTitle = " + movieTitle);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        URI httpUri = UriComponentsBuilder.fromHttpUrl("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2")
                .queryParam("ServiceKey","A781D10R473CFAM21E2R")
                .queryParam("title",movieTitle)
                .queryParam("listCount",10)
                .queryParam("detail","y")
                .queryParam("sort","RANK,1")
                .queryParam("type","극영화")
                .build().encode().toUri();

        System.out.println(httpUri);

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                httpUri,
                HttpMethod.GET,
                entity,
                String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(response.getBody());
        JSONArray jsonData = (JSONArray) jsonObject.get("Data");
        JSONObject jsonObject2 = (JSONObject) jsonData.get(0);
        JSONArray jsonResultArr = (JSONArray) jsonObject2.get("Result");
        List<ApiMovieDto> findMovieList = new ArrayList<>();

        for (int i = 0; i < jsonResultArr.size() ; i++) {
            JSONObject result = (JSONObject) jsonResultArr.get(i);
            JSONObject plots = (JSONObject) result.get("plots");
            JSONArray plot = (JSONArray)plots.get("plot");
            JSONObject last = (JSONObject)plot.get(0);
            String str = (String)last.get("plotText");
            ApiMovieDto movieDto = ApiMovieDto.builder()
                            .title((String)result.get("title"))
                            .posterUrl((String)result.get("posters"))
                            .synopsis(str)
                            .build();
            findMovieList.add(movieDto);
        }

        return findMovieList;
    }

    public List<ApiMovieDto> getMoviesFromTmdb(String movieTitle) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();
        List<ApiMovieDto> movieList = new ArrayList<>();
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/search/movie?query="+movieTitle+"&include_adult=false&language=ko-KR&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYjBmMTMwZDA5MDM5ZjA5NWIyMzA0ZTNjN2U5ZDY3OCIsInN1YiI6IjY1NjU0YjhkZDk1NDIwMDBlMTg5NjYzMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n6Ch9CEH6wK1N_4kc6WUEARL66kVdLFxQtSXPmA2VUA")
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(body);
        JSONArray jsonArray = (JSONArray)jsonObject.get("results");

        for(int i=0 ;i < jsonArray.size();i++){
            JSONObject result = (JSONObject) jsonArray.get(i);
            String title = (String) result.get("title");
            Long id = (Long) result.get("id");
            String synopsis = (String) result.get("overview");
            String posterPath = (String) result.get("poster_path");
            ApiMovieDto dto = ApiMovieDto.builder()
                    .title(title)
                    .movieId(id)
                    .synopsis(synopsis)
                    .posterUrl("https://image.tmdb.org/t/p/original"+posterPath)
                    .build();
            movieList.add(dto);

        }
        return movieList;
    }

    public ApiMovieDto apiMovieView(Long movieId) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/"+movieId+"?language=ko-KR")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYjBmMTMwZDA5MDM5ZjA5NWIyMzA0ZTNjN2U5ZDY3OCIsInN1YiI6IjY1NjU0YjhkZDk1NDIwMDBlMTg5NjYzMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n6Ch9CEH6wK1N_4kc6WUEARL66kVdLFxQtSXPmA2VUA")
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(body);
        String title = (String) jsonObject.get("title");
        String synopsis = (String) jsonObject.get("overview");
        String posterPath = (String) jsonObject.get("poster_path");

        ApiMovieDto dto = ApiMovieDto.builder()
                .movieId(movieId)
                .title(title)
                .synopsis(synopsis)
                .posterUrl("https://image.tmdb.org/t/p/original"+posterPath)
                .build();

        return dto;
    }

}
