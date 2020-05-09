package krish.instagrambackend.service;

import java.util.List;
import java.util.UUID;
import krish.instagrambackend.dto.LoginUserRequestDto;
import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;

public interface UserService {

  UserEntity saveUser(RegisterUserDto registerUserDto);

  boolean isUserNameAvailable(String username);

  boolean isEmailAvailable(String email);

  List<UserEntity> fetchAllUsers(String token);

  String loginUser(LoginUserRequestDto loginUserRequestDto);

  UserEntity getUser(UUID uuid);

}
