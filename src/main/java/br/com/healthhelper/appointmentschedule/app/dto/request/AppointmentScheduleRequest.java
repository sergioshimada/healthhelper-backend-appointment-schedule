package br.com.healthhelper.appointmentschedule.app.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentScheduleRequest {

    private String uuid;
    private String customerName;
    private String customerUuid;
    private String treatmentName;
    private String treatmentUuid;
    private LocalDateTime scheduleStart;
    private LocalDateTime scheduleEnd;
}
