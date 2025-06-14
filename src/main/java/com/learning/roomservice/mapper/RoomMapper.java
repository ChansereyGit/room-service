package com.learning.roomservice.mapper;

import com.learning.roomservice.domain.Room;
import com.learning.roomservice.dto.RoomDTO;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public Room toRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setName(roomDTO.getName());
        room.setAttributes(roomDTO.getAttributes());
        return room;
    }

    public RoomDTO toRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(room.getName());
        roomDTO.setAttributes(room.getAttributes());
        return roomDTO;
    }
}
