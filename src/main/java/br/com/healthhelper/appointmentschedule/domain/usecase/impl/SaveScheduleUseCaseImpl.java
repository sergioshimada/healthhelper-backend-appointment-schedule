package br.com.healthhelper.appointmentschedule.domain.usecase.impl;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.gateway.AppointmentScheduleGateway;
import br.com.healthhelper.appointmentschedule.domain.usecase.SaveScheduleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SaveScheduleUseCaseImpl implements SaveScheduleUseCase {

    private AppointmentScheduleGateway appointmentScheduleGateway;

    @Override
    public AppointmentSchedule execute(AppointmentSchedule appointmentSchedule) {
        appointmentSchedule.setUuid(UUID.randomUUID());
        return appointmentScheduleGateway.saveSchedule(appointmentSchedule);
    }
}
