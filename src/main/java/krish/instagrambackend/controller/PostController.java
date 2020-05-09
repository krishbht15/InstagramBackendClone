package krish.instagrambackend.controller;

import java.util.List;
import java.util.UUID;
import javax.persistence.criteria.CriteriaBuilder.In;
import krish.instagrambackend.entities.PostEntity;
import krish.instagrambackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RestController
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping("/create")
  private ResponseEntity<?> createPost(
      @RequestHeader(name = "token")
          String token,
      @RequestHeader(name = "username")
          String username,
      @RequestParam("userid") UUID uuid, @RequestParam("img") String imageUrl,
      @RequestParam(name = "desc", required = false) String description,
      @RequestParam(name = "refid", required = false) Integer refId) {
    return new ResponseEntity(
        postService.createPost(token, username, uuid, imageUrl, description, refId),
        HttpStatus.OK);
  }

  @GetMapping("/getPosts")
  private ResponseEntity<?> getPosts(@RequestHeader(name = "token")
      String token,
      @RequestHeader(name = "username")
          String username,
      @RequestParam("userid") UUID uuid) {
    return new ResponseEntity(postService.getPosts(token, username, uuid), HttpStatus.OK);
  }


  @PostMapping("like")
  private ResponseEntity<?> likePost(@RequestHeader(name = "token")
      String token,
      @RequestHeader(name = "username")
          String username, @RequestParam(name = "userid") UUID userid,
      @RequestParam(name = "postid") UUID postid){
    return new ResponseEntity(postService.likePost(token,username,userid,postid),HttpStatus.OK);
  }
}
