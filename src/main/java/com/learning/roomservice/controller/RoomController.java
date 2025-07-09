package com.learning.roomservice.controller;

import com.learning.roomservice.dto.RoomDTO;
import com.learning.roomservice.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
    @Operation(summary = "Get room by ID", parameters = @Parameter(in = ParameterIn.PATH, name = "roomId"))
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

    @GetMapping("/search")
    public Flux<RoomDTO> findRoomByName(@RequestParam String name) {
        return roomService.searchRoomByName(name);
    }
}
