package br.com.healthhelper.appointmentschedule.domain.usecase;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface FindAppointmentsByDayUseCase {

    List<AppointmentSchedule> execute(LocalDateTime scheduleStart, LocalDateTime scheduleEnd);
}
