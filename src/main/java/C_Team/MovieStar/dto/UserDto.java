package C_Team.MovieStar.dto;

import C_Team.MovieStar.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    public String User_Id;
    public String User_Password;
    public String User_Tel;
    public String User_Name;

    public UserEntity toEntity(UserDto dto){
        return UserEntity.builder()
                .id(dto.getUser_Id())
                .pw(dto.getUser_Password())
                .tel(dto.getUser_Tel())
                .name(dto.getUser_Name())
                .build();
    }
}
