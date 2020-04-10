package krish.instagrambackend.controller;

import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@RequestBody RegisterUserDto registerUserDto) {
        UserEntity userEntity = userService.saveUser(registerUserDto);
        if (userEntity != null) {
            return new ResponseEntity<>(userEntity.getUuid().toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Email or User Name is already taken.", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/isUserNameAvail")
    private ResponseEntity isUserNameAvail(@RequestParam(name = "user_name") String username) {
        return new ResponseEntity(userService.isUserNameAvailable(username), HttpStatus.OK);
    }

    @GetMapping("/isEmailAvail")
    private ResponseEntity isEmailAvail(@RequestParam(name = "email") String email) {
        return new ResponseEntity(userService.isEmailAvailable(email), HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    private ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity(userService.fetchAllUsers(), HttpStatus.OK);
    }

}
