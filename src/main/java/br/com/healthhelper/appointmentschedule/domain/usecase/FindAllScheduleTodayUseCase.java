package br.com.healthhelper.appointmentschedule.domain.usecase;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;

import java.util.List;

public interface FindAllScheduleTodayUseCase {

    List<AppointmentSchedule> execute();
}
