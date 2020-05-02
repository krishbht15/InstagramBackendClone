package krish.instagrambackend.service;

import java.util.List;
import java.util.UUID;
import krish.instagrambackend.entities.PostEntity;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  PostEntity createPost(String token, String username, UUID uuid, String imageUrl,
      String description, Integer refId);

  List<PostEntity> getPosts(String token, String username, UUID uuid);
}
