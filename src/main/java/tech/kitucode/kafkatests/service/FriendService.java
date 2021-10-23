package tech.kitucode.kafkatests.service;

import org.springframework.stereotype.Service;
import tech.kitucode.kafkatests.domain.Friend;

import java.util.Map;

@Service
public class FriendService {

    private final Map<String, Friend> friendMap;

    public FriendService(Map<String, Friend> friendMap) {
        this.friendMap = friendMap;
    }

    public Friend add(Friend friend){

        this.friendMap.put(friend.getEmail(), friend);

        return friend;
    }

    public Map<String,Friend> getAll(){

        return friendMap;
    }
}
