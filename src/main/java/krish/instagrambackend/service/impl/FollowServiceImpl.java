package krish.instagrambackend.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import krish.instagrambackend.dto.FollowTransactionDto;
import krish.instagrambackend.dto.UserDto;
import krish.instagrambackend.entities.FollowTransactionEntity;
import krish.instagrambackend.entities.UserEntity;
import krish.instagrambackend.repository.FollowRepository;
import krish.instagrambackend.repository.UserRepository;
import krish.instagrambackend.service.FollowService;
import krish.instagrambackend.util.AesPassword;
import krish.instagrambackend.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  public List<UserDto> getFollowing(UUID uuid) throws Exception {
    UserEntity userEntity = userRepository.getOne(uuid);

    return getFollowingUsers(userEntity);
  }

  @Override
  public List<UserDto> getFollowers(UUID uuid) throws Exception {
    UserEntity userEntity = userRepository.getOne(uuid);

    return getFollowersUsers(userEntity);
  }


  private List<UserDto> getFollowingUsers(UserEntity userEntity) throws Exception {
    List<UserDto> result = new ArrayList<>();
    System.out.println("following");
    for (FollowTransactionEntity followTransactionEntity : userEntity.getFollowing()
    ) {
      System.out.println(followTransactionEntity);
      if (followTransactionEntity.getFrom().equals(userEntity.getUuid())) {
        System.out.println("in try");
        try (UserEntity userEntity1 = userRepository.getOne(followTransactionEntity.getTo())) {
          UserDto userDto = new UserDto();
          FollowTransactionDto followTransactionDto = new FollowTransactionDto();
          BeanUtils.copyProperties(userEntity1, userDto);
          result.add(userDto);
        }
      }
    }
    return result;
  }

  private List<UserDto> getFollowersUsers(UserEntity userEntity) throws Exception {
    List<UserDto> result = new ArrayList<>();
    System.out.println("followers");
    for (FollowTransactionEntity followTransactionEntity : userEntity.getFollowers()
    ) {
      System.out.println(followTransactionEntity);
      if (followTransactionEntity.getTo().equals(userEntity.getUuid())) {
        System.out.println("in try");
        try (UserEntity userEntity1 = userRepository.getOne(followTransactionEntity.getFrom())) {
          System.out.println("tried");
          UserDto userDto = new UserDto();
          BeanUtils.copyProperties(userEntity1, userDto);
          result.add(userDto);
        }
      }
    }
    return result;
  }

  @Override
  @Transactional
  public String unfollow(String token, String userName, UUID from, UUID to) {
    if (jwtUtil.validateToken(token, userName)) {
      String id = AesPassword.encrypt(from.toString() + to.toString());
      System.out.println(id
      );
      FollowTransactionEntity followTransactionEntity = followRepository
          .getFollowTransactionEntityByTransactionId(
              id);
      System.out.println(followTransactionEntity);

            followRepository.deleteFollowTransactionEntityransactionEntityByFromAndTo(from, to);

      return "Unfollow transaction successfully ";
    }
    return "Unfollow transaction unsuccessfully ";
  }
}
