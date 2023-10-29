package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.UserDto;
import C_Team.MovieStar.entity.UserEntity;
import C_Team.MovieStar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto){
        UserEntity entity = userDto.toEntity(userDto);
        userRepository.save(entity);
        return userDto;
    }





}
