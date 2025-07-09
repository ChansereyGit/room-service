package com.learning.roomservice.repository;

import com.learning.roomservice.domain.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {

    Flux<Room> findByNameContainingIgnoreCase(String name);
}
