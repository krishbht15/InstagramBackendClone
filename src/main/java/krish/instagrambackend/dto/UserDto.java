package krish.instagrambackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import krish.instagrambackend.entities.BaseEntity;
import krish.instagrambackend.entities.FollowTransactionEntity;
import krish.instagrambackend.entities.GenderEntity;
import krish.instagrambackend.entities.ProfileStatusEntity;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Data
public class UserDto implements Serializable {

  @JsonProperty("uuid")
  private UUID uuid;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("bio")
  private String bio;

  @JsonProperty("photo_url")
  private String photoUrl;

  @JsonProperty("gender")
  private GenderEntity gender;

  @JsonProperty("profile_status")
  private ProfileStatusEntity profileStatus;

  @JsonProperty("followers")
  private List<FollowTransactionDto> followers;

  @JsonProperty("following")
  private List<FollowTransactionDto> following;

}
