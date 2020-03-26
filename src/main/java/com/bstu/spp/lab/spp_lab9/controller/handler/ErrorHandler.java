package com.bstu.spp.lab.spp_lab9.controller.handler;

import com.bstu.spp.lab.spp_lab9.exception.JobAlreadyOccupied;
import com.bstu.spp.lab.spp_lab9.exception.WorkerAlreadyHasJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Error handler.
 */
@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    /**
     * Handle validation exception string.
     *
     * @param exception the exception
     * @return the string
     */
    @ExceptionHandler(JobAlreadyOccupied.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleValidationException(final JobAlreadyOccupied exception) {
        LOGGER.info("ValidationException exception was thrown ({})", exception.getMessage());
        return createModelAndView(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    /**
     * Handle internal server exception string.
     *
     * @param exception the exception
     * @return the string
     */
    @ExceptionHandler(WorkerAlreadyHasJob.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleInternalServerException(final WorkerAlreadyHasJob exception) {
        LOGGER.info("InternalServerException exception was thrown ({})", exception.getMessage());
        return createModelAndView(HttpStatus.BAD_REQUEST, exception.getMessage());
    }


    /**
     * Handle internal server error string.
     *
     * @param exception the exception
     * @return the string
     */
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleInternalServerException(final HttpServerErrorException.InternalServerError exception) {
        LOGGER.info("InternalServerError error was thrown ({})", exception.getMessage());
        return createModelAndView(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    private ModelAndView createModelAndView(final HttpStatus errorStatus, final String errorMsg) {
        ModelAndView model = new ModelAndView();
        model.setStatus(errorStatus);
        model.addObject("errorMessage", errorMsg);
        model.addObject("errorCode", errorStatus.toString());
        model.setViewName("errorPage");
        return model;
    }
}
