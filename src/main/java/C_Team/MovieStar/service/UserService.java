package C_Team.MovieStar.service;

import C_Team.MovieStar.dto.UserDto;
import C_Team.MovieStar.entity.UserEntity;
import C_Team.MovieStar.repository.UserRepository;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto){
        UserEntity entity = userDto.toEntity(userDto);
        userRepository.save(entity);
        return userDto;
    }

    public boolean loginUser(UserDto userDto) {
        String userId = userDto.getUserId();
        String userPw = userDto.getUserPassword();
        Optional<UserEntity> entity = userRepository.findByUserId(userId);
        if (entity.isEmpty()) {
            return false;
        }
        String entityPw = entity.get().getUserPassword();
        // 로그인이 성공하면 true 반환
        return entityPw.equals(userPw);
    }
}
