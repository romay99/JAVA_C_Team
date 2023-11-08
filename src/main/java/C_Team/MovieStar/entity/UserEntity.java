package C_Team.MovieStar.entity;

import C_Team.MovieStar.dto.UserDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class UserEntity {
    @Id
    @Column(name = "user_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;

    @Column(name="user_id")
    private String userId;

    @Column(name = "user_Password")
    private String userPassword;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name="user_name")
    private String userName;

    @Builder
    public UserEntity(String id,String pw,String tel,String name){
    this.userId = id;
    this.userPassword = pw;
    this.userName = name;
    this.userTel = tel;
    }
}
