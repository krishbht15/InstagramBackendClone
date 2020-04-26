package krish.instagrambackend.service;

import java.util.List;
import java.util.UUID;
import krish.instagrambackend.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface FollowService {

  public String following(String token, String userName, UUID from, UUID to);

  List<UserDto> getFollowing(UUID uuid) throws Exception;

  List<UserDto> getFollowers(UUID uuid) throws Exception;

  String unfollow(String token, String userName, UUID from, UUID to);

}
