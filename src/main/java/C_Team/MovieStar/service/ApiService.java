package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.ApiMovieDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
                    .movieId((String)result.get("movieSeq"))
                            .synopsis(str)
                            .build();
            findMovieList.add(movieDto);
        }

        return findMovieList;
    }

}
