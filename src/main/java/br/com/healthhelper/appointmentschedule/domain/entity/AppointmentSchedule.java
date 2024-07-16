package br.com.healthhelper.appointmentschedule.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentSchedule {

    private Long id;
    private UUID uuid;
    private String customerName;
    private UUID customerUuid;
    private String treatmentName;
    private UUID treatmentUuid;
    private LocalDateTime scheduleStart;
    private LocalDateTime scheduleEnd;
}
