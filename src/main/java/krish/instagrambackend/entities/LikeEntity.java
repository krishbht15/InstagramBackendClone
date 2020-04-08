package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "likes")
public class LikeEntity extends BaseEntity {
    @Column(name = "post")
    private UUID postId;

    @ManyToOne
    @Column(name = "user_id")
    private UserEntity userId;
}
