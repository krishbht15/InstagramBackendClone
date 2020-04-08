package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "gender")
@Entity
@Data
public class GenderEntitiy extends BaseStaticEntity{

}
