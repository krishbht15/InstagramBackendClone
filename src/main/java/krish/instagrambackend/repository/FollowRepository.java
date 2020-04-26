package krish.instagrambackend.repository;

import java.util.UUID;
import krish.instagrambackend.entities.FollowTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FollowRepository extends JpaRepository<FollowTransactionEntity, UUID> {

  //INSERT INTO table_name (seri, klasor) VALUES ('Naruto',567)
//WHERE NOT EXISTS( SELECT seri,klasor FROM table_name WEHERE seri='Naruto' AND klasor=567
//)
  FollowTransactionEntity save(FollowTransactionEntity followTransactionEntity);

  @Transactional
  @Modifying
  @Query("delete from FollowTransactionEntity b where b.from=:from AND b.to=:to"  )
  int deleteByFromAndTo(UUID from, UUID to);
  FollowTransactionEntity getFollowTransactionEntityByTransactionId(String id);
//  int deleteFollowTransactionEntity(FollowTransactionEntity followTransactionEntity);
  int deleteFollowTransactionEntityransactionEntityByFromAndTo(UUID from, UUID to);
}
