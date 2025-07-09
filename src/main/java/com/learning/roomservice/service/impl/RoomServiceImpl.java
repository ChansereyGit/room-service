package com.learning.roomservice.service.impl;

import com.learning.roomservice.domain.Room;
import com.learning.roomservice.dto.RoomDTO;
import com.learning.roomservice.exception.RoomNotFoundException;
import com.learning.roomservice.mapper.RoomMapper;
import com.learning.roomservice.repository.RoomRepository;
import com.learning.roomservice.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Mono<RoomDTO> createRoom(RoomDTO roomDTO) {
        log.debug("Saving room to DB: {}", roomDTO);
        Room room = roomMapper.toRoom(roomDTO);
        return roomRepository.save(room)
                .doOnSuccess(saved -> log.info("Room saved {}", saved))
//                .map(r -> roomMapper.toRoomDTO(r)); --> lambda
                .map(roomMapper::toRoomDTO);
    }

    @Override
    public Mono<RoomDTO> getRoomById(String id) {
        log.debug("Getting room by id {}", id);
        return roomRepository.findById(id)
                .switchIfEmpty(Mono.error(new RoomNotFoundException(id)))
                .doOnNext(room -> log.info("Room found: {}", room))
                .map(roomMapper::toRoomDTO);

    }

    @Override
    public Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO) {
        log.debug("Updating room with id {} with data : {}", id, roomDTO);
        return roomRepository.findById(id)
                .switchIfEmpty(Mono.error(new RoomNotFoundException(id)))
                .flatMap(existing ->{
                    existing.setName(roomDTO.getName());
                    existing.setAttributes(roomDTO.getAttributes());
                    Mono<Room> monoRoom = roomRepository.save(existing);
                    return monoRoom;
                })
                .map(roomMapper::toRoomDTO);
    }

    @Override
    public Mono<Void> deleteRoom(String id) {
        log.debug("Deleting room with id {}", id);
        return roomRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new RoomNotFoundException(id)))
                .doOnSuccess(deleted -> log.info("Room deleted {}", id));
    }

    @Override
    public Flux<RoomDTO> searchRoomByName(String name) {
        return roomRepository.findByNameContainingIgnoreCase(name)
                .map(roomMapper::toRoomDTO);
    }
}
