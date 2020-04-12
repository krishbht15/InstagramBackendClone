package krish.instagrambackend.repository;

import krish.instagrambackend.entities.FollowTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FollowRepository extends JpaRepository<FollowTransactionEntity, UUID> {


}
