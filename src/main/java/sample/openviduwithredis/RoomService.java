package sample.openviduwithredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomRedisRepository roomRedisRepository;

    @Autowired
    private OpenViduService openViduService;

    public void saveRoomToRedis(RoomRedis room) {
        roomRedisRepository.save(room);
    }

    public RoomRedis getRoomFromRedis(String roomId) {
        return roomRedisRepository.findById(roomId).orElse(null);
    }

    @Transactional
    public void saveRoomToRdbms(Room room) {
        roomRepository.save(room);
    }

    public RoomRedis createRoom() throws Exception {
        String sessionId = openViduService.createSession();
        RoomRedis room = new RoomRedis();
        room.setId(sessionId);
        room.setSessionId(sessionId);
        saveRoomToRedis(room);
        return room;
    }
}

