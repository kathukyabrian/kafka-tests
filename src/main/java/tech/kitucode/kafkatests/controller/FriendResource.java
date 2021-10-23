package tech.kitucode.kafkatests.controller;

import org.springframework.web.bind.annotation.*;
import tech.kitucode.kafkatests.domain.Friend;
import tech.kitucode.kafkatests.service.FriendService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class FriendResource {

    private final FriendService friendService;

    public FriendResource(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/friend")
    public Friend save(@RequestBody Friend friend){

        return friendService.add(friend);
    }

    @GetMapping("/friend")
    public Map<String,Friend> getAll(){

        return friendService.getAll();
    }
}
