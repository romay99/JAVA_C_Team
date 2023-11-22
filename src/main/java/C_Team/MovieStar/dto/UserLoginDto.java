package C_Team.MovieStar.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserLoginDto {
    private String userId;
    private String userPassword;
}
