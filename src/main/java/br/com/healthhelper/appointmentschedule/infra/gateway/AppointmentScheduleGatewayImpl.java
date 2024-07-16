package br.com.healthhelper.appointmentschedule.infra.gateway;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.gateway.AppointmentScheduleGateway;
import br.com.healthhelper.appointmentschedule.infra.db.model.AppointmentScheduleModel;
import br.com.healthhelper.appointmentschedule.infra.db.repository.AppointmentScheduleRepository;
import br.com.healthhelper.appointmentschedule.infra.mapper.AppointmentScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentScheduleGatewayImpl implements AppointmentScheduleGateway {

    private AppointmentScheduleRepository appointmentScheduleRepository;
    private AppointmentScheduleMapper appointmentScheduleMapper;

    @Override
    public AppointmentSchedule saveSchedule(AppointmentSchedule appointmentSchedule) {
        AppointmentScheduleModel save = appointmentScheduleRepository.save(appointmentScheduleMapper.domainToModel(appointmentSchedule));
        return appointmentScheduleMapper.modelToDomain(save);
    }

    @Override
    public List<AppointmentSchedule> findAppointmentsByDay(LocalDateTime scheduleStart, LocalDateTime scheduleEnd) {

        return appointmentScheduleRepository.findAppointmentScheduleModelByScheduleStartGreaterThanEqualAndScheduleEndGreaterThanEqual(scheduleStart, scheduleEnd)
                .stream()
                .map(appointmentScheduleMapper::modelToDomain)
                .collect(Collectors.toList());
    }
}
