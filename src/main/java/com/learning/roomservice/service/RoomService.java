package com.learning.roomservice.service;

import com.learning.roomservice.dto.RoomDTO;
import reactor.core.publisher.Mono;

public interface RoomService {
    Mono<RoomDTO> createRoom(RoomDTO roomDTO);
    Mono<RoomDTO> getRoomById(String id);
    Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO);
}
