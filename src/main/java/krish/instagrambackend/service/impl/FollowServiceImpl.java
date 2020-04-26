package krish.instagrambackend.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import krish.instagrambackend.entities.FollowTransactionEntity;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.repository.FollowRepository;
import krish.instagrambackend.repository.UserRepository;
import krish.instagrambackend.service.FollowService;
import krish.instagrambackend.util.AesPassword;
import krish.instagrambackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

  @Autowired
  private FollowRepository followRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JwtUtil jwtUtil;

  @Override
  public String following(String token, String userName, UUID from, UUID to) {
    if (jwtUtil.validateToken(token, userName)) {
      System.out.println("valid token");
      FollowTransactionEntity followTransactionEntity = new FollowTransactionEntity();
      followTransactionEntity.setFrom(from);
      followTransactionEntity.setTo(to);
      followTransactionEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
      followTransactionEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
      System.out.println("entity is ready " + followTransactionEntity);
      followTransactionEntity
          .setTransactionId(AesPassword.encrypt(from.toString() + to.toString()));
      System.out.println(
          followTransactionEntity.getCreatedAt().toString() + followTransactionEntity
              .getUpdatedAt()
              .toString());
      followRepository.save(followTransactionEntity);

      return "Following transaction completed successful!";

    }
    System.out.println("invalid token");

    return "Transaction got failed";
  }

  @Override
  public List<UserEntity> getFollowing(UUID uuid) throws Exception {
    UserEntity userEntity = userRepository.getOne(uuid);

    return getFollowingUsers(userEntity);
  }

  @Override
  public List<UserEntity> getFollowers(UUID uuid) throws Exception {
    UserEntity userEntity = userRepository.getOne(uuid);

    return getFollowersUsers(userEntity);
  }

  private List<UserEntity> getFollowingUsers(UserEntity userEntity) throws Exception {
    List<UserEntity> result = new ArrayList<>();
    System.out.println("following");
    for (FollowTransactionEntity followTransactionEntity : userEntity.getFollowing()
    ) {
      System.out.println(followTransactionEntity);
      if (followTransactionEntity.getFrom().equals(userEntity.getUuid())) {
        System.out.println("in try");
        try (UserEntity userEntity1 = userRepository.getOne(followTransactionEntity.getTo())) {
          System.out.println("tried");
          result.add(userEntity1);
        }
      }
    }
    return result;
  }

  private List<UserEntity> getFollowersUsers(UserEntity userEntity) throws Exception {
    List<UserEntity> result = new ArrayList<>();
    System.out.println("followers");
    for (FollowTransactionEntity followTransactionEntity : userEntity.getFollowers()
    ) {
      System.out.println(followTransactionEntity);
      if (followTransactionEntity.getTo().equals(userEntity.getUuid())) {
        System.out.println("in try");
        try (UserEntity userEntity1 = userRepository.getOne(followTransactionEntity.getFrom())) {
          System.out.println("tried");
          result.add(userEntity1);
        }
      }
    }
    return result;
  }
}
