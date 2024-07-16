package br.com.healthhelper.appointmentschedule.domain.usecase;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;

public interface SaveScheduleUseCase {

    AppointmentSchedule execute(AppointmentSchedule appointmentSchedule);
}
