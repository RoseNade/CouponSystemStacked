package com.example.jb.Project2Againwoohoo.security;

import com.example.jb.Project2Againwoohoo.beans.ClientType;
import com.example.jb.Project2Againwoohoo.exceptions.CouponSecurityExceptions;
import com.example.jb.Project2Againwoohoo.exceptions.SecurityErrMsg;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Getter
public class TokenManager {

    private final Map<UUID, Info> map = new HashMap<>();

    /**
     * A function to return the info of a user that was added to the website
     * @param info - info regarding the user his email, current time, id, client type
     * @return a UUID(Token for the user to use for upcoming tasks)
     */
    public UUID add(Info info) {
        removePreviousInstances(info.getUserId());
        UUID token = UUID.randomUUID();
        map.put(token, info);
        return token;
    }

    public int getUserId(UUID uuid) throws CouponSecurityExceptions {
        if (map.get(uuid) == null) {
            throw new CouponSecurityExceptions(SecurityErrMsg.CREDENTIALS_WRONG);
        }
        return map.get(uuid).getUserId();
    }

    public ClientType getUserType(UUID uuid) throws CouponSecurityExceptions {
        if (map.get(uuid) == null) {
            throw new CouponSecurityExceptions(SecurityErrMsg.CREDENTIALS_WRONG);
        }
        return map.get(uuid).getClientType();
    }

    public boolean isAdminToken(UUID token) throws CouponSecurityExceptions {
        Info info = map.get(token);
        if (info == null) {
            throw new CouponSecurityExceptions(SecurityErrMsg.INVALID_TOKEN);
        }

        if(info.getClientType() != ClientType.ADMIN){
            throw new CouponSecurityExceptions(SecurityErrMsg.INVALID_TOKEN);
        }

        return true;
    }

    @Scheduled(fixedRate = 1_000 * 60 * 60)
    public void deleteExpiredTokens() {
        // remove the token is older than 30 min
        map.entrySet().removeIf(instance -> instance.getValue().getTime().isAfter(LocalDateTime.now().minusMinutes(30)));
    }

    public void removePreviousInstances(int userId) {
        map.entrySet().removeIf(instance -> instance.getValue().getUserId() == userId);
    }
}
