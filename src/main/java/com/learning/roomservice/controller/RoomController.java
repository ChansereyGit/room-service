package com.learning.roomservice.controller;

import com.learning.roomservice.dto.RoomDTO;
import com.learning.roomservice.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Mono<RoomDTO> createRoom(@Valid @RequestBody RoomDTO roomDTO) {
        return roomService.createRoom(roomDTO);
    }

    @GetMapping("/{roomId}")
    public Mono<RoomDTO> getRoomById(@PathVariable String roomId) {
        return roomService.getRoomById(roomId);
    }

    @PutMapping("/{roomId}")
    public Mono<RoomDTO> updateRoom(@PathVariable String roomId, @RequestBody RoomDTO roomDTO) {
        return roomService.updateRoom(roomId, roomDTO);
    }

    @DeleteMapping("/{roomId}")
    public Mono<Void> deleteRoom(@PathVariable String roomId) {
        return roomService.deleteRoom(roomId);
    }
}
