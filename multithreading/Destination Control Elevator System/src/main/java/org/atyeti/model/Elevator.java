package org.atyeti.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {
    private int id;
    private int currentFloor;
    private ElevatorState state;
}
