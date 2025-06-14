package com.learning.roomservice.service.impl;

import com.learning.roomservice.domain.Room;
import com.learning.roomservice.dto.RoomDTO;
import com.learning.roomservice.mapper.RoomMapper;
import com.learning.roomservice.repository.RoomRepository;
import com.learning.roomservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Mono<RoomDTO> createRoom(RoomDTO roomDTO) {
        Room room = roomMapper.toRoom(roomDTO);
        Mono<RoomDTO> mono = roomRepository.save(room)
                .map(r -> roomMapper.toRoomDTO(r));
        return mono;
    }
}
