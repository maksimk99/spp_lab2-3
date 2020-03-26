package com.bstu.spp.lab.spp_lab9.exception;

public class WorkerAlreadyHasJob extends RuntimeException {

    public WorkerAlreadyHasJob(final String message) {
        super(message);
    }
}
