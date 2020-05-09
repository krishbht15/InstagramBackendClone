package krish.instagrambackend.service.impl;

import java.util.List;
import java.util.UUID;
import javax.persistence.criteria.CriteriaBuilder.In;
import krish.instagrambackend.entities.LikeEntity;
import krish.instagrambackend.entities.PostEntity;
import krish.instagrambackend.entities.PostStatusEntity;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.repository.PostRepository;
import krish.instagrambackend.repository.PostStatusRepository;
import krish.instagrambackend.service.LikeService;
import krish.instagrambackend.service.PostService;
import krish.instagrambackend.service.UserService;
import krish.instagrambackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;
  private PostStatusRepository postStatusRepository;
  private JwtUtil jwtUtil;
  private UserService userService;
  private LikeService likeService;

  @Autowired
  public PostServiceImpl(PostRepository postRepository,
      PostStatusRepository postStatusRepository, JwtUtil jwtUtil, UserService userService,
      LikeService likeService) {
    this.postRepository = postRepository;
    this.postStatusRepository = postStatusRepository;
    this.jwtUtil = jwtUtil;
    this.userService = userService;
    this.likeService = likeService;
  }


  @Override
  public PostEntity createPost(String token, String username, UUID uuid, String imageUrl,
      String description, Integer refId) {
    if (jwtUtil.validateToken(token, username)) {
      PostEntity postEntity = new PostEntity();

      postEntity.setImageUrl(imageUrl);
      postEntity.setDescription(description);
      postEntity.setUserId(uuid);
      PostStatusEntity postStatusEntity = null;
      if (refId != null) {
        postStatusEntity = postStatusRepository.getByRefId(refId);
      } else {
        postStatusEntity = postStatusRepository.getByRefId(1);
      }
      postEntity.setStatus(postStatusEntity);
      return postRepository.save(postEntity);
    }
    return null;
  }

  @Override
  public List<PostEntity> getPosts(String token, String username, UUID uuid) {
    if (jwtUtil.validateToken(token, username)) {
      return postRepository.findAllByUserId(uuid);
    }
    return null;
  }

  @Override
  public boolean likePost(String token, String username, UUID userid, UUID post) {
    LikeEntity likeEntity = new LikeEntity();
    likeEntity.setPostId(post);
//    UserEntity likeUser = userService.getUser(userid);
    likeEntity.setLikeUser(userid);
//    PostEntity postEntity = postRepository.getOne(post);
//    UserEntity postUser = userService.getUser(postEntity.getUserId());
    likeEntity.setUserId(post);
    likeService.like(likeEntity);
    return true;
  }
}
