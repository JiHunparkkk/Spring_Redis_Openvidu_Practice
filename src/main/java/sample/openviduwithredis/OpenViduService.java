package sample.openviduwithredis;

import io.openvidu.java.client.OpenVidu;
import io.openvidu.java.client.Session;
import io.openvidu.java.client.SessionProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenViduService {

    private OpenVidu openVidu;

    public OpenViduService(@Value("${openvidu.url}") String openViduUrl,
                           @Value("${openvidu.secret}") String openViduSecret) {
        this.openVidu = new OpenVidu(openViduUrl, openViduSecret);
    }

    public String createSession() throws Exception {
        SessionProperties properties = new SessionProperties.Builder().build();
        Session session = openVidu.createSession(properties);
        return session.getSessionId();
    }
}
