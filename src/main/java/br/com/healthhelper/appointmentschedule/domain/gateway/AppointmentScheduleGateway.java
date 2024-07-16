package br.com.healthhelper.appointmentschedule.domain.gateway;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentScheduleGateway {

    AppointmentSchedule saveSchedule(AppointmentSchedule appointmentSchedule);
    List<AppointmentSchedule> findAppointmentsByDay(LocalDateTime scheduleStart, LocalDateTime scheduleEnd);
}
