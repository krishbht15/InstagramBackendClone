package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "posts_status")
@Entity
@Data
public class PostStatusEntity extends BaseStaticEntity{

}
