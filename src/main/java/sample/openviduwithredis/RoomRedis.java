package sample.openviduwithredis;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Room")
public class RoomRedis implements Serializable {

    private String id;
    private String sessionId;

    // Getter and Setter methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
