package com.learning.roomservice.dto;

import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
public class RoomDTO {
    private String name;
    private Map<String, Object> attributes;
}
