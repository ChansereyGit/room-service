package com.learning.roomservice.repository;

import com.learning.roomservice.domain.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {
}
