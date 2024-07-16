package br.com.healthhelper.appointmentschedule.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ScheduleNotAvailableException.class)
    ProblemDetail handleCustomerNotExistsException(ScheduleNotAvailableException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getLocalizedMessage());
        problemDetail.setTitle("schedule not available");
        problemDetail.setDetail("this schedule not available, use other schedule");
        problemDetail.setProperty("Category", "Platform");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(InsertCalendarException.class)
    ProblemDetail handleInsertCalendarException(InsertCalendarException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        problemDetail.setTitle("error to schedule event in calendar");
        problemDetail.setDetail("error to insert event in api calendar.");
        problemDetail.setProperty("Category", "Platform");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }
}
