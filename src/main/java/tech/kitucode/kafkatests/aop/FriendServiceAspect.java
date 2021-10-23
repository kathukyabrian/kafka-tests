package tech.kitucode.kafkatests.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import tech.kitucode.kafkatests.domain.Friend;

@Slf4j
@Aspect
@Component
public class FriendServiceAspect {

    @Before(value = "execution(* tech.kitucode.kafkatests.service.FriendService.*(..)) and args(friend)")
    public void beforeAdvice(JoinPoint joinPoint, Friend friend){
        log.info("Before method : {}",joinPoint.getSignature());
        log.info("Adding friend with name : {}",friend.getName());
    }

    @After(value = "execution(* tech.kitucode.kafkatests.service.FriendService.*(..)) and args(friend)")
    public void afterAdvice(JoinPoint joinPoint, Friend friend){
        log.info("After method : {}",joinPoint.getSignature());
        log.info("Successfully added friend with name : {}",friend.getName());
    }
}
