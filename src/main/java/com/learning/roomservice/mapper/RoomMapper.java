package com.learning.roomservice.mapper;

import com.learning.roomservice.domain.Room;
import com.learning.roomservice.dto.RoomDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toRoom(RoomDTO roomDTO);

    RoomDTO toRoomDTO(Room room);

    /*
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
     */
}
