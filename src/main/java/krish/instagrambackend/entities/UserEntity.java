package krish.instagrambackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

  @OneToMany(cascade = CascadeType.DETACH)
  @JoinColumn(name = "to_user")
  private List<FollowTransactionEntity> followers;

  @OneToMany(cascade = CascadeType.DETACH)
  @JoinColumn(name = "from_user")
  private List<FollowTransactionEntity> following;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private List<PostEntity> allPosts;


}
