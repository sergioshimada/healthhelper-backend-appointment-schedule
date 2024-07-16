package br.com.healthhelper.appointmentschedule.domain.usecase.impl;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.gateway.CalendarGateway;
import br.com.healthhelper.appointmentschedule.domain.usecase.FindAppointmentsByDayUseCase;
import br.com.healthhelper.appointmentschedule.domain.usecase.IAppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.usecase.SaveScheduleUseCase;
import br.com.healthhelper.appointmentschedule.shared.exception.ScheduleNotAvailableException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AppointmentScheduleImpl implements IAppointmentSchedule {

    private FindAppointmentsByDayUseCase findAppointmentsByDayUseCase;
    private SaveScheduleUseCase saveScheduleUseCase;
    private CalendarGateway calendarGateway;

    @Override
    public AppointmentSchedule execute(AppointmentSchedule appointmentSchedule) {

        List<AppointmentSchedule> appointmentsByDay = findAppointmentsByDayUseCase.execute(appointmentSchedule.getScheduleStart(), appointmentSchedule.getScheduleEnd());

        if (appointmentsByDay.size() > 2) {
            log.error("schedule not available");
            throw new ScheduleNotAvailableException();
        }

        AppointmentSchedule appointmentScheduleSaved = saveScheduleUseCase.execute(appointmentSchedule);
        calendarGateway.insertSchedule(appointmentScheduleSaved);

        return appointmentScheduleSaved;
    }
}
