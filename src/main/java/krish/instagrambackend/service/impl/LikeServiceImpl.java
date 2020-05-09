package krish.instagrambackend.service.impl;

import krish.instagrambackend.entities.LikeEntity;
import krish.instagrambackend.repository.LikeRepository;
import krish.instagrambackend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

  private LikeRepository likeRepository;

  @Autowired
  public LikeServiceImpl(LikeRepository likeRepository) {
    this.likeRepository = likeRepository;
  }

  @Override
  public LikeEntity like(LikeEntity likeEntity) {
    LikeEntity likeEntity1 = likeRepository
        .findByUserIdAndPostId(likeEntity.getUserId(), likeEntity.getPostId()).get(0);
    System.out.println(likeEntity1);
    if (likeEntity1.getUuid() == null) {
      return likeRepository.save(likeEntity);
    }
    return null;
  }
}
