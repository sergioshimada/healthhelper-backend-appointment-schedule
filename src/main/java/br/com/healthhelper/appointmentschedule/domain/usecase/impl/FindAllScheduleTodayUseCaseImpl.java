package br.com.healthhelper.appointmentschedule.domain.usecase.impl;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.usecase.FindAppointmentsByDayUseCase;
import br.com.healthhelper.appointmentschedule.domain.usecase.FindAllScheduleTodayUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FindAllScheduleTodayUseCaseImpl implements FindAllScheduleTodayUseCase {

    private FindAppointmentsByDayUseCase findAppointmentsByDayUseCase;

    @Override
    public List<AppointmentSchedule> execute() {

        LocalDateTime initDay = LocalDate.now().atTime(6, 0);
        LocalDateTime endDay = LocalDate.now().atTime(23, 59);

        return findAppointmentsByDayUseCase.execute(initDay, endDay);
    }
}
