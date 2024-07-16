package br.com.healthhelper.appointmentschedule.infra.gateway;

import br.com.healthhelper.appointmentschedule.domain.entity.AppointmentSchedule;
import br.com.healthhelper.appointmentschedule.domain.gateway.CalendarGateway;
import br.com.healthhelper.appointmentschedule.infra.client.CalendarEventsRequest;
import br.com.healthhelper.appointmentschedule.infra.client.EndRequest;
import br.com.healthhelper.appointmentschedule.infra.client.StartRequest;
import br.com.healthhelper.appointmentschedule.shared.exception.InsertCalendarException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;

@Service
@Slf4j
public class CalendarGatewayImpl implements CalendarGateway {

    @Value("${calendar.token}")
    private String bearerToken;
    @Value("${calendar.url}")
    private String url;
    @Override
    public AppointmentSchedule findAvailableSchedule() {
        return null;
    }

    @Override
    public void insertSchedule(AppointmentSchedule schedule) {

        ResponseEntity<String> response = new RestTemplate().exchange(url + "/primary/events", HttpMethod.POST, makeRequest(schedule), String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("created event of customer: {}, treatment: {}, start: {}, end{}", schedule.getTreatmentName(), schedule.getTreatmentName(), schedule.getScheduleStart().withSecond(1), schedule.getScheduleEnd().withSecond(1));
        } else {
            log.error("error to insert event in calendar. data: customer: {}, treatment: {}, start: {}, end{}", schedule.getTreatmentName(), schedule.getTreatmentName(), schedule.getScheduleStart().withSecond(1), schedule.getScheduleEnd().withSecond(1));
            throw new InsertCalendarException();
        }
    }

    private HttpEntity<String> makeRequest(AppointmentSchedule schedule){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + bearerToken);

        CalendarEventsRequest event =
                new CalendarEventsRequest(
                        new StartRequest(
                                schedule.getScheduleStart().withSecond(1).toString(),
                                ZoneId.systemDefault().getId()),
                        new EndRequest(schedule.getScheduleEnd().withSecond(1).toString(),
                                ZoneId.systemDefault().getId()),
                        "Agenda do cliente:" + schedule.getTreatmentName() + "\nNome tratamento: " + schedule.getTreatmentName(),
                        schedule.getTreatmentName() + "\n" + schedule.getCustomerName()
                );
       return new HttpEntity<>(new Gson().toJson(event), headers);
    }
}
