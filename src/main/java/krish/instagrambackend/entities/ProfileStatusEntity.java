package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "profile_status")
@Entity
@Data
public class ProfileStatusEntity extends BaseStaticEntity {

}
