package krish.instagrambackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "follow_transaction")
public class FollowTransactionEntity extends BaseEntity {

    @Column(name = "from")
    private UUID from;

    @Column(name = "to")
    private UUID to;

}
