package br.com.healthhelper.appointmentschedule.app.controller;

import br.com.healthhelper.appointmentschedule.app.dto.request.AppointmentScheduleRequest;
import br.com.healthhelper.appointmentschedule.app.dto.response.AppointmentScheduleResponse;
import br.com.healthhelper.appointmentschedule.app.mapper.AppointmentScheduleAppMapper;
import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.usecase.FindAllScheduleTodayUseCase;
import br.com.healthhelper.appointmentschedule.domain.usecase.IAppointmentSchedule;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/appointment-schedule")
@AllArgsConstructor
public class AppointmentScheduleController {

    private IAppointmentSchedule appointmentSchedule;
    private FindAllScheduleTodayUseCase findAllScheduleTodayUseCase;
    private AppointmentScheduleAppMapper mapper;

    @PostMapping
    public @ResponseBody ResponseEntity<AppointmentScheduleResponse> save(@RequestBody final AppointmentScheduleRequest request) {
        AppointmentSchedule appointmentSchedule = this.appointmentSchedule.execute(mapper.requestToDomain(request, UUID.fromString(request.getUuid()), UUID.fromString(request.getCustomerUuid()), UUID.fromString(request.getTreatmentUuid())));
        return new ResponseEntity<>(mapper.domainToResponse(appointmentSchedule), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentScheduleResponse>> findAllScheduleToday(){

        List<AppointmentScheduleResponse> scheduleResponses = findAllScheduleTodayUseCase.execute().stream().map(mapper::domainToResponse).collect(Collectors.toList());
        return new ResponseEntity<>(scheduleResponses, HttpStatus.OK);
    }
}