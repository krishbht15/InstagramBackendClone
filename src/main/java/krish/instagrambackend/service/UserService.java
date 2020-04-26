package krish.instagrambackend.service;

import krish.instagrambackend.dto.LoginUserRequestDto;
import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserEntity saveUser(RegisterUserDto registerUserDto);

    boolean isUserNameAvailable(String username);

    boolean isEmailAvailable(String email);

    List<UserEntity> fetchAllUsers(String token);

    String loginUser(LoginUserRequestDto loginUserRequestDto);

//    String following(String token, String userName,UUID from, UUID to);
}
