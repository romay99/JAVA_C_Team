package C_Team.MovieStar.entity;

import C_Team.MovieStar.dto.UserDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int USER_CODE;

    @Column
    private String User_Id;

    @Column
    private String User_Password;

    @Column
    private String User_Tel;

    @Column
    private String User_Name;

    @Builder
    public UserEntity(String id,String pw,String tel,String name){
    this.User_Id = id;
    this.User_Password = pw;
    this.User_Name = name;
    this.User_Tel = tel;
    }
}
