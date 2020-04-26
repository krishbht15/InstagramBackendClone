package krish.instagrambackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "follow_transaction")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FollowTransactionEntity extends BaseEntity {

  @Column(name = "from_user")
  private UUID from;

  @Column(name = "to_user")
  private UUID to;

  @Column(name = "transaction_id")
  private String transactionId;

}
