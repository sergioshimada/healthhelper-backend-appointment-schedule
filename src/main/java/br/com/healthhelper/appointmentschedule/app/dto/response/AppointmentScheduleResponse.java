package br.com.healthhelper.appointmentschedule.app.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AppointmentScheduleResponse {

    private Long id;
    private UUID uuid;
    private String customerName;
    private String customerUuid;
    private String treatmentName;
    private String treatmentUuid;
    private LocalDate scheduleStart;
    private LocalDate scheduleEnd;
}
