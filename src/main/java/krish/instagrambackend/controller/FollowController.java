package krish.instagrambackend.controller;

import java.util.UUID;
import krish.instagrambackend.service.FollowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
public class FollowController {


  @Autowired
  private FollowService followService;

  @PostMapping("")
  private ResponseEntity<?> followTransaction(@RequestHeader(name = "token") String token,
      @RequestHeader(name = "username") String username, @RequestParam(name = "from") UUID from,
      @RequestParam(name = "to") UUID to) {
    return new ResponseEntity(followService.following(token, username, from, to), HttpStatus.OK);
  }

  @GetMapping("getFollowing")
  private ResponseEntity<?> getFollowing(@RequestHeader(name = "token") String token,
      @RequestHeader(name = "username") String username, @RequestParam(name = "uuid") UUID uuid)
      throws Exception {
    return new ResponseEntity(followService.getFollowing(uuid), HttpStatus.OK);
  }

  @GetMapping("getFollowers")
  private ResponseEntity<?> getFollowers(@RequestHeader(name = "token") String token,
      @RequestHeader(name = "username") String username, @RequestParam(name = "uuid") UUID uuid)
      throws Exception {
    return new ResponseEntity(followService.getFollowers(uuid), HttpStatus.OK);
  }
}
