package br.com.healthhelper.appointmentschedule.app.mapper;

import br.com.healthhelper.appointmentschedule.app.dto.request.AppointmentScheduleRequest;
import br.com.healthhelper.appointmentschedule.app.dto.response.AppointmentScheduleResponse;
import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AppointmentScheduleAppMapper {

    AppointmentScheduleResponse domainToResponse(AppointmentSchedule appointmentSchedule);

    @Mapping(target = "uuid", source = "uuidConverted")
    @Mapping(target = "customerUuid", source = "customerUuidConverted")
    @Mapping(target = "treatmentUuid", source = "treatmentUuidConverted")
    AppointmentSchedule requestToDomain(AppointmentScheduleRequest appointmentScheduleRequest, UUID uuidConverted, UUID customerUuidConverted, UUID treatmentUuidConverted);
}
