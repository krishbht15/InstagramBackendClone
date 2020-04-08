package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Table(name = "posts")
@Entity
public class PostEntity extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @ManyToOne
    private PostStatusEntity status;

    @Column(name = "user_id")
    private UUID userId;
}
