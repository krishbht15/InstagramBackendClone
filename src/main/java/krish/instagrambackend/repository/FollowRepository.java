package krish.instagrambackend.repository;

import java.util.UUID;
import krish.instagrambackend.entities.FollowTransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<FollowTransactionEntity, UUID> {

//INSERT INTO table_name (seri, klasor) VALUES ('Naruto',567)
//WHERE NOT EXISTS( SELECT seri,klasor FROM table_name WEHERE seri='Naruto' AND klasor=567
//)
  FollowTransactionEntity save(FollowTransactionEntity followTransactionEntity);
}
