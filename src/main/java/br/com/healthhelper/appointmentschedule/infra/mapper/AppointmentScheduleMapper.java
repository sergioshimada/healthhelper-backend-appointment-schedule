package br.com.healthhelper.appointmentschedule.infra.mapper;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.infra.db.model.AppointmentScheduleModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentScheduleMapper {

    AppointmentScheduleModel domainToModel(AppointmentSchedule appointmentSchedule);
    AppointmentSchedule modelToDomain(AppointmentScheduleModel appointmentSchedule);
}
