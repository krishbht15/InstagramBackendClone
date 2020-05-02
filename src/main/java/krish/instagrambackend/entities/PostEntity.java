package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "posts")
@Entity
public class PostEntity extends BaseEntity {

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "status")
  private PostStatusEntity status;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "image_url")
  private String imageUrl;
}
