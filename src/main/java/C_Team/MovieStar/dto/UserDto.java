package C_Team.MovieStar.dto;

import C_Team.MovieStar.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UserDto {
    public String UserId;
    public String UserPassword;
    public String UserTel;
    public String UserName;

    public UserEntity toEntity(UserDto dto){
        return UserEntity.builder()
                .id(dto.getUserId())
                .pw(dto.getUserPassword())
                .tel(dto.getUserTel())
                .name(dto.getUserName())
                .build();
    }
}
