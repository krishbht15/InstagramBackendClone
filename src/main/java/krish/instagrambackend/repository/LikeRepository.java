package krish.instagrambackend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import krish.instagrambackend.entities.LikeEntity;
import krish.instagrambackend.entities.PostStatusEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, UUID> {

  List<LikeEntity> findByUserIdAndPostId(UUID userid, UUID postid);

}
