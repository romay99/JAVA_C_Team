package C_Team.MovieStar.entity;

import C_Team.MovieStar.dto.UserDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "user_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserCode;

    @Column(name="user_id")
    private String UserId;

    @Column(name = "user_Password")
    private String UserPassword;

    @Column(name = "user_tel")
    private String UserTel;

    @Column(name="user_name")
    private String UserName;

    @Builder
    public UserEntity(String id,String pw,String tel,String name){
    this.UserId = id;
    this.UserPassword = pw;
    this.UserName = name;
    this.UserTel = tel;
    }
}
