package br.com.healthhelper.appointmentschedule.domain.usecase.impl;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.gateway.AppointmentScheduleGateway;
import br.com.healthhelper.appointmentschedule.domain.usecase.FindAppointmentsByDayUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FindAppointmentsByDayUseCaseImpl implements FindAppointmentsByDayUseCase {

    private AppointmentScheduleGateway appointmentScheduleGateway;

    @Override
    public List<AppointmentSchedule> execute(LocalDateTime scheduleStart, LocalDateTime scheduleEnd) {
        return appointmentScheduleGateway.findAppointmentsByDay(scheduleStart, scheduleEnd);
    }
}
