package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "bio")
    private String bio;

    @Column(name = "photo_url")
    private String photoUrl;

    @JoinColumn(name = "gender")
    @ManyToOne
    private GenderEntity gender;

    @JoinColumn(name = "profile_status")
    @ManyToOne
    private ProfileStatusEntity profileStatus;


}
