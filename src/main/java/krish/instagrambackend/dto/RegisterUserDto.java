package krish.instagrambackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterUserDto {

    @JsonProperty("password")
    private String password;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
}