package tech.kitucode.kafkatests.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import tech.kitucode.kafkatests.domain.Friend;
import tech.kitucode.kafkatests.service.FriendService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class FriendResource {

    private final FriendService friendService;

    private final KafkaTemplate<String, Friend> kafkaTemplate;

    public FriendResource(FriendService friendService, KafkaTemplate<String, Friend> kafkaTemplate) {
        this.friendService = friendService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/friend")
    public Friend save(@RequestBody Friend friend){
        kafkaTemplate.send("friend",friend.getEmail(),friend);
        return friendService.add(friend);
    }

    @GetMapping("/friend")
    public Map<String,Friend> getAll(){
        return friendService.getAll();
    }

    @KafkaListener(topics = "friend", groupId = "friend")
    @GetMapping("/kafka/friend")
    public void getFromKafka(Friend friend){
        log.info("Consumed : {}",friend);
    }
}
