package krish.instagrambackend.service;

import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;

public interface UserService {
    UserEntity saveUser(RegisterUserDto registerUserDto);
    boolean isUserNameAvailable(String  username);
}
