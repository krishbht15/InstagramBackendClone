package krish.instagrambackend.service;

import java.util.List;
import java.util.UUID;
import krish.instagrambackend.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface FollowService {

  public String following(String token, String userName, UUID from, UUID to);

  List<UserEntity> getFollowing(UUID uuid) throws Exception;

  List<UserEntity> getFollowers(UUID uuid) throws Exception;


}
