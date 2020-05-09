package krish.instagrambackend.service;

import krish.instagrambackend.entities.LikeEntity;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {

  LikeEntity like(LikeEntity likeEntity);
}
