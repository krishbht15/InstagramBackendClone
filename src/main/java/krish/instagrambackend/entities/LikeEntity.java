package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "likes")
public class LikeEntity extends BaseEntity {

  @Column(name = "post")
  private UUID postId;


  @Column(name = "user_id")
  private UUID userId;


  @Column(name = "like_user")
  private UUID likeUser;
}
