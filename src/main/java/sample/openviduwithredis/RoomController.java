package sample.openviduwithredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/redis")
    public void saveRoomToRedis(@RequestBody RoomRedis room) {
        roomService.saveRoomToRedis(room);
    }

    @GetMapping("/redis/{id}")
    public RoomRedis getRoomFromRedis(@PathVariable String id) {
        return roomService.getRoomFromRedis(id);
    }

    @PostMapping("/rdbms")
    public void saveRoomToRdbms(@RequestBody Room room) {
        roomService.saveRoomToRdbms(room);
    }

    @PostMapping("/create")
    public RoomRedis createRoom() throws Exception {
        return roomService.createRoom();
    }
}

