package krish.instagrambackend.service.impl;

import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.repository.UserRepository;
import krish.instagrambackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(RegisterUserDto registerUserDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerUserDto.getEmail());
        userEntity.setName(registerUserDto.getName());
        userEntity.setPassword(registerUserDto.getPassword());
        userEntity.setUserName(registerUserDto.getUserName());
        try {
            userRepository.save(userEntity);

        } catch (Exception e) {
            System.out.println("s,nlkfsnnsflnlo");
            return null;

        }
        return null;
    }

    @Override
    public boolean isUserNameAvailable(String username) {
        return userRepository.existsByUserName(username);
    }
}