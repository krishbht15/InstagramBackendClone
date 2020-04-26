package krish.instagrambackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import krish.instagrambackend.entities.BaseEntity;
import lombok.Data;

@Data
public class FollowTransactionDto {

  private UUID uuid;

  private UUID from;

  private UUID to;

  private String transactionId;

}
