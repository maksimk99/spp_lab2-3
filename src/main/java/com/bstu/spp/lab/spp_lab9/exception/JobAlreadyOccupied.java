package com.bstu.spp.lab.spp_lab9.exception;

public class JobAlreadyOccupied extends RuntimeException {

    public JobAlreadyOccupied(final String message) {
        super(message);
    }
}
