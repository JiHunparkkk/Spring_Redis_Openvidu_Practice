package sample.openviduwithredis;

import org.springframework.data.repository.CrudRepository;

public interface RoomRedisRepository extends CrudRepository<RoomRedis, String> {
}
