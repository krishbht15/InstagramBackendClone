package krish.instagrambackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginUserRequestDto {

    @JsonProperty("password")
    private String password;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("email")
    private String email;
}