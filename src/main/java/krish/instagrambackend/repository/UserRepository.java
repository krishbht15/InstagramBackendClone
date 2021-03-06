package krish.instagrambackend.repository;

import krish.instagrambackend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

    UserEntity findByUserNameOrEmail(String userName, String email);
}
