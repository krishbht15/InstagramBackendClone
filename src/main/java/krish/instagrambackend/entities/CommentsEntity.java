package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "comments")
@Entity
@Data
public class CommentsEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id ")
    private UserEntity userId;

    @Column(name = "data")
    private String data;

    @Column(name = "post")
    private UUID postId;


}
