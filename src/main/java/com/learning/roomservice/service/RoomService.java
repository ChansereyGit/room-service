package com.learning.roomservice.service;

import com.learning.roomservice.dto.RoomDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {
    Mono<RoomDTO> createRoom(RoomDTO roomDTO);
    Mono<RoomDTO> getRoomById(String id);
    Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO);
    Mono<Void> deleteRoom(String id);
    Flux<RoomDTO> searchRoomByName(String name);
}
