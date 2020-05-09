package krish.instagrambackend.repository;

import java.util.List;
import java.util.UUID;
import krish.instagrambackend.entities.FollowTransactionEntity;
import krish.instagrambackend.entities.PostEntity;
import krish.instagrambackend.service.PostService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> {

  List<PostEntity> findAllByUserId(UUID user);
}
