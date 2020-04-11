package krish.instagrambackend.service.impl;

import com.sun.xml.fastinfoset.stax.events.Util;
import krish.instagrambackend.dto.LoginUserRequestDto;
import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.repository.UserRepository;
import krish.instagrambackend.service.UserService;
import krish.instagrambackend.util.AesPassword;
import krish.instagrambackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.Utilities;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(RegisterUserDto registerUserDto) {
        UserEntity userEntity = new UserEntity();
        if (isEmailAvailable(registerUserDto.getEmail()) && isUserNameAvailable(registerUserDto.getUserName())) {
            userEntity.setEmail(registerUserDto.getEmail());
            userEntity.setName(registerUserDto.getName());
            userEntity.setPassword(AesPassword.encrypt(registerUserDto.getPassword()));
            userEntity.setUserName(registerUserDto.getUserName());
            try (UserEntity userEntity1 = userRepository.save(userEntity);
            ) {
                return userEntity1;
            } catch (Exception e) {
                System.out.println("s,nlkfsnnsflnlo");
                return null;

            }
        }
        return null;
    }

    @Override
    public boolean isUserNameAvailable(String username) {
        if (userRepository.existsByUserName(username)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        if (userRepository.existsByEmail(email)) {
            return false;
        }
        return true;
    }

    @Override
    public List<UserEntity> fetchAllUsers(String token) {
        if (jwtUtil.validateToken(token, "krish15")) {
            return userRepository.findAll();
        }
        return null;
    }

    @Override
    public String loginUser(LoginUserRequestDto loginUserRequestDto) {
        try (UserEntity userEntity = userRepository.findByUserNameOrEmail(loginUserRequestDto.getUserName(), loginUserRequestDto.getEmail())) {
            if (loginUserRequestDto.getPassword().equals(AesPassword.decrypt(userEntity.getPassword()))) {
                return jwtUtil.generateToken(userEntity.getUserName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "false";
    }
}
