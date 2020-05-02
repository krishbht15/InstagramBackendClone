package krish.instagrambackend.repository;

import java.util.UUID;
import krish.instagrambackend.entities.PostEntity;
import krish.instagrambackend.entities.PostStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostStatusRepository extends JpaRepository<PostStatusEntity, UUID> {

  PostStatusEntity getByRefId(int refId);
}
