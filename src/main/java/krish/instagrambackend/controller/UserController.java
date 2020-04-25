package krish.instagrambackend.controller;

import krish.instagrambackend.dto.LoginUserRequestDto;
import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@RequestBody RegisterUserDto registerUserDto) throws Exception {

        UserEntity userEntity = userService.saveUser(registerUserDto);
        if (userEntity != null) {
            return new ResponseEntity<>(userEntity.getUuid().toString(), HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>("Email or Username is already taken.", HttpStatus.NOT_ACCEPTABLE);
        }

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
    private ResponseEntity<List<UserEntity>> getUsers(@RequestHeader(name = "token") String header) {
        return new ResponseEntity(userService.fetchAllUsers(header), HttpStatus.OK);
    }

    @GetMapping("/login")
    private ResponseEntity loginUser(@RequestBody LoginUserRequestDto loginUserRequestDto) {
        System.out.println("loginnnnnnnnnnnnnnn");
        return new ResponseEntity(userService.loginUser(loginUserRequestDto), HttpStatus.OK);
    }

    @PostMapping("/follow")
    private ResponseEntity<?> followTransaction(@RequestHeader(name = "token") String token, @RequestHeader(name = "username") String username, @RequestParam(name = "from") UUID from, @RequestParam(name = "to") UUID to) {
        return new ResponseEntity(userService.following(token, username, from, to), HttpStatus.OK);
    }

}
