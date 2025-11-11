package org.atyeti.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private int sourceFloor;
    private int destinationFloor;

}