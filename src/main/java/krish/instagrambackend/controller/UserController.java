package krish.instagrambackend.controller;

import krish.instagrambackend.dto.RegisterUserDto;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>("No data", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/unavail")
    private ResponseEntity isAvail(@RequestParam(name = "un") String username) {
        return new ResponseEntity(userService.isUserNameAvailable(username), HttpStatus.OK);
    }


}
